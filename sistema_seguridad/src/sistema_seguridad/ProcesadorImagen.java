/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.Queue;

/**
 *
 * @author federico
 */
public class ProcesadorImagen implements Runnable {

   
    ProcesadorImagen(Queue<Imagen> imagenesAProcesar) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void run() {
        Imagen imagen = Buffers.imagenesAProcesar.peek();
        procesar(imagen);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void procesar(Imagen imagen){
        // procesar imagene
    }

    
    
    
}
