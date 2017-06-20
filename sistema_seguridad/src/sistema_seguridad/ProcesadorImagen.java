/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;

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
//                try {
//                    imagen.setMomentoLeida(Reloj.getInstance().getMomentoActual());
//                    //Thread.sleep(imagen.getTiempoProcesamiento()*Reloj.getInstance().getVelocidad());
//                } catch (InterruptedException ex) {
//                }
                procesar(imagen);
            }        
            } catch (IOException ex) {
            }
        }
        
        
    }
    
    public void procesar(Imagen imagen) throws IOException{
        Delincuente delincuente = BaseDatos.getInstance().esDelincuente(imagen);
        if (delincuente!=null){
            Alerta alerta  = new Alerta(imagen,delincuente,Reloj.getInstance().getMomentoActual());
            Buffers.alertasANotificar.add(alerta);
            Logger.getInstancia().log("Alerta agregada "+ alerta.getPersona().getNombre());
            
        }
    }
    
    
}