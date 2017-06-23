 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.concurrent.Semaphore;

/**
 *
 * @author federico
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Buffers.inicializarBuffers();
        
        // Se levantan los archivos: Delincuentes.csv, PrioridadCamaras.csv, y CodigoImagenPatron.csv
        BaseDatos.cargarDatos();
        
        // Se inicializan los semaforos
        Semaphore semImagen = new Semaphore(1);
        Semaphore semAlerta = new Semaphore(1);
        
        
        // Hilos del sistema
        Thread receptorImagenThread = new Thread(new ReceptorImagen(semImagen));
        Thread procesadorImagenTrhead = new Thread(new ProcesadorImagen(semImagen,semAlerta));
        Thread procesadorImagenTrhead2 = new Thread(new ProcesadorImagen(semImagen,semAlerta));
        Thread notificadorThread = new Thread(new Notificador(semAlerta));

        Thread reloj = new Thread(Reloj.getInstance());

        reloj.start();
        receptorImagenThread.start();
        procesadorImagenTrhead.start();
        procesadorImagenTrhead2.start();
        notificadorThread.start();


        Logger.getInstancia().log("Se inician hilos de simulacion");
        
        // Inicio de la simulacion
        new Thread(new Simulador()).start();
        
    }
}
