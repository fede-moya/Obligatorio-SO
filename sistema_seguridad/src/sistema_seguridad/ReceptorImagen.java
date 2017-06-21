/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.logging.Level;
import java.util.concurrent.Semaphore;


/**
 *
 * @author federico
 */
public class ReceptorImagen implements Runnable{

    private Semaphore semImagen;
    
    @Override
    public void run() {
        while (true) {   
            Imagen proximaImagen = PlanificadorReceptor.getProximaImagen();
            if (proximaImagen != null) {
                try {
                    semImagen.acquire();
                    Buffers.imagenesAProcesar.add(proximaImagen);
                    Logger.getInstancia().log("Lista para procesar | imagen " + proximaImagen.getCodigo());
                    semImagen.release();
                } catch (IOException | InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }            
            }
        }
    }

    public ReceptorImagen(Semaphore semImagen) {
        this.semImagen = semImagen;
    }
    
    
    
    
}
