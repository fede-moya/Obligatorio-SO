 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

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
        Semaphore semImagenProductor = new Semaphore(1);
        Semaphore semImagenConsumidor = new Semaphore(0);
        Semaphore semImagenMutex = new Semaphore(1);
        
        Semaphore semAlertaProductor = new Semaphore(1);
        Semaphore semAlertaConsumidor = new Semaphore(0);
        Semaphore semAlertaMutex = new Semaphore(1);
        
        
        
        // Hilos del sistema        
        Thread receptorImagenThread = new Thread(new ReceptorImagen(semImagenProductor,semImagenConsumidor,semImagenMutex));
        Thread procesadorImagenTrhead = new Thread(new ProcesadorImagen(semImagenProductor,semImagenConsumidor,semImagenMutex,semAlertaProductor,semAlertaConsumidor,semAlertaMutex));
        Thread procesadorImagenTrhead2 = new Thread(new ProcesadorImagen(semImagenProductor,semImagenConsumidor,semImagenMutex,semAlertaProductor,semAlertaConsumidor,semAlertaMutex));
        Thread notificadorThread = new Thread(new Notificador(semAlertaProductor,semAlertaConsumidor,semAlertaMutex));

        Thread reloj = new Thread(Reloj.getInstance());

        reloj.start();
        receptorImagenThread.start();
        procesadorImagenTrhead.start();
//        procesadorImagenTrhead2.start();
        notificadorThread.start();


        Logger.getInstancia().log("Se inician hilos de simulacion");
        
        // Inicio de la simulacion
        
        Thread simulador = new Thread(new Simulador());
        simulador.start();
        
        
        /* Script para hacer que el programa termine despues de 30 segundos */
        for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(30);stop>System.nanoTime();) {}
        simulador.stop();
        reloj.stop();
        receptorImagenThread.stop();
        procesadorImagenTrhead.stop();
        procesadorImagenTrhead2.stop();
        notificadorThread.stop();
        Logger.getInstancia().log("Simulacion Finalizada");
        /* Fin del script */
        
        
        
        
    }
}
