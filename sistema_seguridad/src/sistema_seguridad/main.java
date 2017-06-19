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


        while ( Reloj.getInstance().getMomentoActual()<=3){
            System.out.println(Reloj.getInstance().getMomentoActual());
        };
        System.out.println("Se ejecuto");
        procesadorImagenTrhead.start();
        while ( Reloj.getInstance().getMomentoActual()<=5){
            System.out.println(Reloj.getInstance().getMomentoActual());
        };
        notificadorThread.start();
        
    }
}
