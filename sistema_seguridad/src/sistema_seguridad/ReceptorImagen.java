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
public class ReceptorImagen implements Runnable{

    @Override
    public void run() {
        while (true) {       
            Imagen proximaImagen = PlanificadorReceptor.getProximaImagen();
            if (proximaImagen != null) {
                Buffers.imagenesAProcesar.add(proximaImagen);
                try {
                    Logger.getInstancia().log("imagen " + proximaImagen.getIdImagen() + " en espera de procesamiento");
                    System.out.println(proximaImagen.getIdCamara() + " imagen " + proximaImagen.getIdImagen() + " en espera de procesamiento");
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(ReceptorImagen.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        }
    }
}
