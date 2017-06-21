/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;


/**
 *
 * @author federico
 */
public class Notificador implements Runnable {
    
    private Semaphore semAlerta;
    
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
        if(!Buffers.alertasANotificar.isEmpty())
        {
            semAlerta.acquireUninterruptibly();
            Alerta notificacion = Buffers.alertasANotificar.poll();
            notificacion.setMomentoNotificada(Reloj.getInstance().getMomentoActual());
            Imagen imagen  = notificacion.getRequerido();
            String idTablet = "D" + imagen.getIdCamara().substring(1, imagen.getIdCamara().length());
            String texto = "Salerta enviada | " + 
                    "Tablet: " + idTablet + " | "+ 
                    "Persona: " + notificacion.getPersona().getNombre() + " " + notificacion.getPersona().getApellido();
//            String texto = "Se ha enviado la alerta al dispositivo: "+idTablet + " sobre " + imagen.get;
            Logger.getInstancia().log(texto);
            semAlerta.release();
        }
        
    }

    public Notificador(Semaphore semAlerta) {
        this.semAlerta = semAlerta;
    }
    
    
    
}
