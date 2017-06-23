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
public class Notificador implements Runnable {
    
    private final Semaphore semAlerta;
    
    @Override
    public void run() {
        while(true){
            try {
                notificar();
            } catch (IOException | InterruptedException ex) {
                
            }
        }
    }
    
    private void notificar() throws IOException, InterruptedException{
        System.out.println("");
        if(!Buffers.alertasANotificar.isEmpty()){
            semAlerta.acquireUninterruptibly();
            Alerta notificacion = Buffers.alertasANotificar.poll();
            notificacion.setMomentoNotificada(Reloj.getInstance().getMomentoActual());
            Imagen imagen  = notificacion.getRequerido();
            String idTablet = "D" + imagen.getIdCamara().substring(1, imagen.getIdCamara().length());
            String texto = "Alerta enviada | " + 
                    "Tablet: " + idTablet + " | "+ 
                    "Persona: " + notificacion.getPersona().getNombre() + " " + notificacion.getPersona().getApellido();
            Logger.getInstancia().log(texto);
            semAlerta.release();
        }
        
    }

    public Notificador(Semaphore semAlerta) {
        this.semAlerta = semAlerta;
    }
    
}
