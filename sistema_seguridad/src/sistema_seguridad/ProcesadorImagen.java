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

   
    ProcesadorImagen() {
        
    }
    @Override
    public void run() {
        //Imagen imagen = Buffers.imagenesAProcesar.peek();
        //procesar(imagen);
        System.out.println("Procesando imagenes");
    }
    
    public void procesar(Imagen imagen){
        // procesar imagene
    }

    
    
    
}
