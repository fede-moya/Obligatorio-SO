/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.ArrayList;

/**
 *
 * @author federico
 */
public class BaseDatosDelicuente {
    ArrayList<Delincuente> delincuentes;

    public BaseDatosDelicuente(String nombreArchivo,String ruta) {
        // inicializa el arraylist de delincuente
    }
      
    public Delincuente esDelincuente(Imagen imagen){
        // devuelve null si no hay ningun delincuente que matchee con la imagen, 
        // devuelve una instancia Delincuente si hay matcheo
        return null;
    }
}
