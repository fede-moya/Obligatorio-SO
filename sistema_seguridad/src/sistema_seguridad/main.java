    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author federico
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        
        Buffers.paraliticos = ManejadorArchivos.leerImagenes("src/sistema_seguridad/filaEspecial.txt", true, "filaEspecial");
        Buffers.colombes = ManejadorArchivos.leerImagenes("src/sistema_seguridad/filaColombes.txt", true, "filaColombes");
        Buffers.amsterdam = ManejadorArchivos.leerImagenes("src/sistema_seguridad/filaAmsterdam.txt", true, "filaAmsterdam");
         
       Buffers.alertasANotificar = new LinkedList();
       Buffers.imagenesAProcesar = new LinkedList();
       

        // Se crean hilos
       Thread receptorImagenThread = new Thread(new ReceptorImagen());
       Thread procesadorImagenTrhead = new Thread(new ProcesadorImagen());
       Thread notificadorThread = new Thread(new Notificador());
       Thread reloj = new Thread(Reloj.getInstance());
       
         
       Logger.instancia = new Logger("Similuacion03");
       Logger.getInstancia().log("Fefito is on fire !!!!");
       Logger.getInstancia().log("que facil la vida!!!!");
       
        // Se inician todos los hilos        
        // Hilo del reloj
        reloj.start();
        // Hilo del receptor de imagenes
        receptorImagenThread.start();
        // Hilo del procesador de imagenes
//        procesadorImagenTrhead.start();
        // Hilo del notificador
//        notificadorThread.start();
        
    }
}
