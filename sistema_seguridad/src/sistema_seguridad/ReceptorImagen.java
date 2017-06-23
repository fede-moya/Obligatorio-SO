/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;


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
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(ReceptorImagen.class.getName()).log(Level.SEVERE, null, ex);
                }
                Buffers.imagenesAProcesar.add(proximaImagen);
                Logger.getInstancia().log("Lista para procesar | imagen " + proximaImagen.getCodigo());
                semImagen.release();
                            
            }
        }
    }

    public ReceptorImagen(Semaphore semImagen) {
        this.semImagen = semImagen;
    }
    
    
    
    
}
