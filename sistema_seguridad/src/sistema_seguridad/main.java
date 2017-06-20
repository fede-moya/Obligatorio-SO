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
        

        Buffers.alertasANotificar = new LinkedList();
        Buffers.imagenesAProcesar = new LinkedList();
        Buffers.amsterdam = new GrupoCamara();
        Buffers.colombes = new GrupoCamara();
        Buffers.america = new GrupoCamara();
        Buffers.olimpica = new GrupoCamara();
        Buffers.especiales = new GrupoCamara();


         //     Hilos del sistema
        Thread receptorImagenThread = new Thread(new ReceptorImagen());
        Thread procesadorImagenTrhead = new Thread(new ProcesadorImagen());
        Thread notificadorThread = new Thread(new Notificador());
        Thread reloj = new Thread(Reloj.getInstance());

        Logger.instancia = new Logger("Similuacion01");
        

        reloj.start();
        receptorImagenThread.start();
        procesadorImagenTrhead.start();
        notificadorThread.start();
        
        //       Hilos de la simulacion
       Thread camarasAmsterdam = new Thread(new SimuladorCamaras("Amsterdam"));
       Thread camarasColombes = new Thread(new SimuladorCamaras("Colombes"));
       Thread camarasOlimpica = new Thread(new SimuladorCamaras("America"));
       Thread camarasAmerica = new Thread(new SimuladorCamaras("Olimpica"));
       Thread camarasEspeciales = new Thread(new SimuladorCamaras("Especiales"));
       
       Logger.getInstancia().log("Se inician hilos de simulacion");
       camarasAmsterdam.start();
       camarasColombes.start();
       camarasOlimpica.start();
       camarasAmerica.start();
       camarasEspeciales.start();
        
    }
}
