/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.concurrent.Semaphore;


/**
 *
 * @author federico
 */
public class ProcesadorImagen implements Runnable {

    //private final Semaphore semImagen;
    private final Semaphore semAlertaProductor;
    private final Semaphore semAlertaConsumidor;
    private final Semaphore semAlertaMutex;
    
    
    private final Semaphore semImagenProductor;
    private final Semaphore semImagenConsumidor;
    private final Semaphore semImagenMutex;

    @Override
    public void run() {
        while (true) {
            try {
                semImagenConsumidor.acquire();
                semImagenMutex.acquire();
                Imagen imagen = Buffers.imagenesAProcesar.poll();
                semImagenMutex.release();
                semImagenProductor.release();

                if (imagen != null) {
//                try {
//                    imagen.setMomentoLeida(Reloj.getInstance().getMomentoActual());
//                    //Thread.sleep(imagen.getTiempoProcesamiento()*Reloj.getInstance().getVelocidad());
//                } catch (InterruptedException ex) {
//                }
                    procesar(imagen);
                }
            } catch (IOException | InterruptedException ex) {
            }
        }

    }

    public void procesar(Imagen imagen) throws IOException, InterruptedException {
        
        Logger.getInstancia().log("Procesando | imagen: " + imagen.getCodigo() + 
                " | Tiempo procesamiento: " + imagen.getTiempoProcesamiento());
        
        int momentoActual = Reloj.getInstance().getMomentoActual();        
        while(imagen.getTiempoProcesamiento() > Reloj.getInstance().getMomentoActual() - momentoActual) {
            // NOOP porque un while vacio no anda
            System.out.println("");
        }
        
        Logger.getInstancia().log("Fin procesamiento | imagen: " + imagen.getCodigo());
        
        Delincuente delincuente = BaseDatos.esDelincuente(imagen);
        if (delincuente != null) {
            Alerta alerta = new Alerta(imagen, delincuente, Reloj.getInstance().getMomentoActual());
            semAlertaProductor.acquire();
            semAlertaMutex.acquire();
            Buffers.alertasANotificar.add(alerta);
            Logger.getInstancia().log("Alerta agregada | " + 
                    "Persona: " + alerta.getPersona().getNombre() + " " + alerta.getPersona().getApellido());
            semAlertaMutex.release();
            semAlertaConsumidor.release();

        }
    }

    public ProcesadorImagen(
            Semaphore imagenProductor,Semaphore imagenConsumidor, Semaphore imagenMutex,
            Semaphore alertaProductor,Semaphore alertaConsumidor, Semaphore alertaMutex) {
        //this.semImagen = semImagen;
        
        this.semImagenProductor = imagenProductor;
        this.semImagenConsumidor = imagenConsumidor;
        this.semImagenMutex = imagenMutex;
        
        this.semAlertaProductor = alertaProductor;
        this.semAlertaConsumidor = alertaConsumidor;
        this.semAlertaMutex = alertaMutex;
    }

}
