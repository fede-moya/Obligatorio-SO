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
    
    
    private final Semaphore semCamaraMutex;
    private final Semaphore semImagenProductor;
    private final Semaphore semImagenConsumidor;
    private final Semaphore semImagenMutex;
    
    @Override
    public void run() {
        while (true) {
            try {
                semCamaraMutex.acquire();
                Imagen proximaImagen = PlanificadorReceptor.getProximaImagen();
                semCamaraMutex.release();
                if (proximaImagen != null) {
                    semImagenProductor.acquire();
                    semImagenMutex.acquire();
                    Buffers.imagenesAProcesar.add(proximaImagen);
                    Logger.getInstancia().log("Lista para procesar | imagen " + proximaImagen.getCodigo());
                    semImagenMutex.release();
                    semImagenConsumidor.release();
                            
            }
            } catch (InterruptedException ex) {            }
            
        }
    }

    public ReceptorImagen(Semaphore camaraMutex, Semaphore productor,Semaphore consumidor,Semaphore mutex) {
        this.semCamaraMutex = camaraMutex;
        this.semImagenProductor = productor;
        this.semImagenConsumidor = consumidor;
        this.semImagenMutex = mutex;
    }
    
    
    
    
}
