/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.logging.Level;

/**
 *
 * @author federico
 */
public class Notificador implements Runnable {
    
    @Override
    public void run() {
        while(true){
            try {
                notificar();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Notificador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void notificar() throws IOException{
        if(!Buffers.alertasANotificar.isEmpty())
        {
            Alerta notificacion = Buffers.alertasANotificar.poll();
            notificacion.setMomentoNotificada(Reloj.getInstance().getMomentoActual());
            Imagen imagen  = notificacion.getRequerido();
            String idTablet = "D" + imagen.getIdCamara().substring(1, imagen.getIdCamara().length());
            String texto = "Se ha enviado la alerta al dispositivo: "+idTablet;
            Logger.getInstancia().log(texto);
        }
        
    }
    
}
