    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author federico
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        
//        Buffers.paraliticos = ManejadorArchivos.leerImagenes("src/sistema_seguridad/filaEspecial.txt", true, "filaEspecial");
//        Buffers.colombes = ManejadorArchivos.leerImagenes("src/sistema_seguridad/filaColombes.txt", true, "filaColombes");
       Buffers.amsterdam = ManejadorArchivos.leerImagenes("Amsterdam.csv", true, "filaAmsterdam");
         
       Buffers.alertasANotificar = new LinkedList();
       Buffers.imagenesAProcesar = new LinkedList();
       

        // Se crean hilos
       Thread receptorImagenThread = new Thread(new ReceptorImagen());
       Thread procesadorImagenTrhead = new Thread(new ProcesadorImagen());
       Thread notificadorThread = new Thread(new Notificador());
       Thread reloj = new Thread(Reloj.getInstance());
       
         
       Logger.instancia = new Logger("Similuacion01");
       Logger.getInstancia().log("Inicio simulacion");
       
       reloj.start();

        receptorImagenThread.start();

        procesadorImagenTrhead.start();

        notificadorThread.start();
        
    }
}
