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

    private final Semaphore semImagenProductor;
    private final Semaphore semImagenConsumidor;
    private final Semaphore semImagenMutex;
    
    @Override
    public void run() {
        while (true) {   
            Imagen proximaImagen = PlanificadorReceptor.getProximaImagen();
            if (proximaImagen != null) {
                try {
                    semImagenProductor.acquire();
                    semImagenMutex.acquire();
                } catch (InterruptedException ex) {
                }
                Buffers.imagenesAProcesar.add(proximaImagen);
                Logger.getInstancia().log("Lista para procesar | imagen " + proximaImagen.getCodigo());
                semImagenMutex.release();
                semImagenConsumidor.release();
                            
            }
        }
    }

    public ReceptorImagen(Semaphore productor,Semaphore consumidor,Semaphore mutex) {
        this.semImagenProductor = productor;
        this.semImagenConsumidor = consumidor;
        this.semImagenMutex = mutex;
    }
    
    
    
    
}
