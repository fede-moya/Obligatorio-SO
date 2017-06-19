/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;

/**
 *
 * @author federico
 */
public class ProcesadorImagen implements Runnable {

    
    @Override
    public void run() {
        while(true){
            try {
            Imagen imagen = Buffers.imagenesAProcesar.poll();
            
                
            if (imagen!=null) {
                Thread.sleep(imagen.getTiempoProcesamiento()*Reloj.getInstance().getVelocidad());
//                try {
//                    imagen.setMomentoLeida(Reloj.getInstance().getMomentoActual());
//                    //Thread.sleep(imagen.getTiempoProcesamiento()*Reloj.getInstance().getVelocidad());
//                } catch (InterruptedException ex) {
//                }
                procesar(imagen);
            }        
            } catch (IOException ex) {
            } catch (InterruptedException ex) {
            }
        }
        
        
    }
    
    public synchronized void procesar(Imagen imagen) throws IOException{
        Delincuente delincuente = BaseDatosDelincuente.getInstance().esDelincuente(imagen);
        if (delincuente!=null){
            Alerta alerta  = new Alerta(imagen,delincuente,Reloj.getInstance().getMomentoActual());
            Buffers.alertasANotificar.add(alerta);
            Logger.getInstancia().log("Alerta agregada "+ alerta.getPersona().getNombre());
            
        }
    }
    
    
}