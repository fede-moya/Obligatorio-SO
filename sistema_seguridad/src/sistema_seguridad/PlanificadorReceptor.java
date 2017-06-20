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

    public static Imagen getProximaImagen() {
        // lista con las primeras imagenes de los grupos de camaras
        ArrayList<Imagen> primerasImagenes = new ArrayList<>();
        Imagen amsterdam = Buffers.amsterdam.getProximaImagen();

        primerasImagenes.add(amsterdam);

        // se obtiene la imagen con mayor prioridad
        Imagen prioritaria = getImagenPrioritaria(primerasImagenes);
        Imagen result = null;
        if (amsterdam != null && prioritaria.getCodigo().equals(primerasImagenes.get(0).getCodigo())) {
            result = Buffers.amsterdam.eliminarImagen();
        }
        if (result != null && result.getMomentoGeneracion() + result.getTiempoEsperando() != Reloj.getInstance().getMomentoActual()) {
            subirPrioridad();
        }
        return result;
    }

    // busca entre las imagenes la de mayor prioridad
    private static Imagen getImagenPrioritaria(ArrayList<Imagen> primerasImagenes) {

        Imagen imagenPrioridadMaxima = null;
        int prioridadMaxima = 0;
        
        for (Imagen imagen : primerasImagenes) {
            if (imagen != null && imagen.getPrioridad() > prioridadMaxima) {
                imagenPrioridadMaxima = imagen;
                prioridadMaxima = imagen.getPrioridad();
            }
        }
        return imagenPrioridadMaxima;
    }

    private static void subirPrioridad() {
        for (Imagen imagen : Buffers.amsterdam.getImagenes()) {
            imagen.setTiempoEsperando(1);
        }
        for (Imagen imagen : Buffers.colombes.getImagenes()) {
            imagen.setTiempoEsperando(1);
        }
        for (Imagen imagen : Buffers.especiales.getImagenes()) {
            imagen.setTiempoEsperando(1);
        }
    }
}
