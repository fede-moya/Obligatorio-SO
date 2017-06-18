/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class PlanificadorReceptor {
    
    public static Imagen getProximaImagen(){
        // lista con las primeras imagenes de los grupos de camaras
        ArrayList<Imagen> primerasImagenes = new ArrayList<>();
        primerasImagenes.add(Buffers.paraliticos.getProximaImagen());
        primerasImagenes.add(Buffers.colombes.getProximaImagen());
        primerasImagenes.add(Buffers.amsterdam.getProximaImagen());
        
        // se obtiene la imagen con mayor prioridad
        Imagen prioritaria = getImagenPrioritaria(primerasImagenes);
        
        if (prioritaria.getIdCamara().equals(primerasImagenes.get(0).getIdCamara())) {
            return Buffers.paraliticos.eliminarImagen();            
        } else if (prioritaria.getIdCamara().equals(primerasImagenes.get(1).getIdCamara())) {
            return Buffers.colombes.eliminarImagen(); 
        } else {
            return Buffers.amsterdam.eliminarImagen();
        }     
    }
    
    // busca entre las imagenes la de mayor prioridad
    private static Imagen getImagenPrioritaria(ArrayList<Imagen> primerasImagenes) {
        
        Imagen imagenPrioridadMaxima = null;
        int prioridadMaxima = 4;
        
        for (Imagen imagen : primerasImagenes) {
            if (imagen.getPrioridad() < prioridadMaxima) {
                imagenPrioridadMaxima = imagen;
                prioridadMaxima = imagen.getPrioridad();
            }
        }
        return imagenPrioridadMaxima;
    }
}
