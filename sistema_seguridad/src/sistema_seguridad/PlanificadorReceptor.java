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
        Imagen paralitico = Buffers.paraliticos.getProximaImagen();
        Imagen colombes = Buffers.colombes.getProximaImagen();
        Imagen amsterdam = Buffers.amsterdam.getProximaImagen();
        
        primerasImagenes.add(paralitico);
        primerasImagenes.add(colombes);
        primerasImagenes.add(amsterdam);
        
        // se obtiene la imagen con mayor prioridad
        Imagen prioritaria = getImagenPrioritaria(primerasImagenes);
        
        if (paralitico != null && prioritaria.getIdImagen().equals(primerasImagenes.get(0).getIdImagen())) {
            return Buffers.paraliticos.eliminarImagen();            
        } else if (colombes != null && prioritaria.getIdImagen().equals(primerasImagenes.get(1).getIdImagen())) {
            return Buffers.colombes.eliminarImagen(); 
        } else if (amsterdam != null && prioritaria.getIdImagen().equals(primerasImagenes.get(2).getIdImagen())) {
            return Buffers.amsterdam.eliminarImagen();
        }
        return null;
    }
    
    // busca entre las imagenes la de mayor prioridad
    private static Imagen getImagenPrioritaria(ArrayList<Imagen> primerasImagenes) {
        
        Imagen imagenPrioridadMaxima = null;
        int prioridadMaxima = 4;
        
        for (Imagen imagen : primerasImagenes) {
            if (imagen != null && imagen.getPrioridad() < prioridadMaxima) {
                imagenPrioridadMaxima = imagen;
                prioridadMaxima = imagen.getPrioridad();
            }
        }
        return imagenPrioridadMaxima;
    }
}
