/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class PlanificadorReceptor {

    public static Imagen getProximaImagen() {
        // lista con las primeras imagenes de los grupos de camaras
        Imagen[] primerasImagenes = new Imagen[5];

        Imagen amsterdam = Buffers.amsterdam.getProximaImagen();
        Imagen colombes = Buffers.colombes.getProximaImagen();
        Imagen especial = Buffers.especiales.getProximaImagen();
        Imagen olimpica = Buffers.olimpica.getProximaImagen();
        Imagen america = Buffers.america.getProximaImagen();

        primerasImagenes[0] = america;
        primerasImagenes[1] = olimpica;
        primerasImagenes[2] = colombes;
        primerasImagenes[3] = amsterdam;
        primerasImagenes[4] = especial;

        // se obtiene la imagen con mayor prioridad
        Imagen prioritaria = getImagenPrioritaria(primerasImagenes);
        Imagen result = null;
        if (prioritaria != null) {

            if (america != null && prioritaria.getCodigo().equals(primerasImagenes[0].getCodigo())) {

                result = Buffers.america.eliminarImagen();
                log("imagen: " + result.getCodigo() + " | tribuna: america" + " | prioridad: " + result.getPrioridad());

            } else if (olimpica != null && prioritaria.getCodigo().equals(primerasImagenes[1].getCodigo())) {

                result = Buffers.olimpica.eliminarImagen();
                log("imagen: " + result.getCodigo() + " | tribuna olimpica " + "| prioridad: " + result.getPrioridad());

            } else if (colombes != null && prioritaria.getCodigo().equals(primerasImagenes[2].getCodigo())) {

                result = Buffers.colombes.eliminarImagen();
                log("imagen: " + result.getCodigo() + " | tribuna: colombes" + " | prioridad: " + result.getPrioridad());

            } else if (amsterdam != null && prioritaria.getCodigo().equals(primerasImagenes[3].getCodigo())) {

                result = Buffers.amsterdam.eliminarImagen();
                log("imagen: " + result.getCodigo() + " | tribuna: amsterdam" + " | prioridad: " + result.getPrioridad());

            } else if (especial != null && prioritaria.getCodigo().equals(primerasImagenes[4].getCodigo())) {

                result = Buffers.especiales.eliminarImagen();
                log("imagen: " + result.getCodigo() + " | tribuna: especial" + " | prioridad: " + result.getPrioridad());
            }

            if (result != null && result.getMomentoGeneracion() + result.getTiempoEsperando() != Reloj.getInstance().getMomentoActual()) {

                subirPrioridad();
            }
        }
        return result;
    }

    // busca entre las imagenes la de mayor prioridad
    // private static Imagen getImagenPrioritaria(ArrayList<Imagen> primerasImagenes) {
    private static Imagen getImagenPrioritaria(Imagen[] primerasImagenes) {

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
            imagen.aumentarTiempoEsperando();
        }
        for (Imagen imagen : Buffers.colombes.getImagenes()) {
            imagen.aumentarTiempoEsperando();
        }
        for (Imagen imagen : Buffers.especiales.getImagenes()) {
            imagen.aumentarTiempoEsperando();
        }
        for (Imagen imagen : Buffers.olimpica.getImagenes()) {
            imagen.aumentarTiempoEsperando();
        }
        for (Imagen imagen : Buffers.america.getImagenes()) {
            imagen.aumentarTiempoEsperando();
        }
    }

    private static void log(String entrada) {
        String fecha = new SimpleDateFormat("dd_MM_HH_mm").format(new Date());
        String base = "| Momento: " + Reloj.getInstance().getMomentoActual() + "|| ";
        String nombre = "Imagenes/" + "Imagenes" + "_" + fecha;
        ManejadorArchivos.escribirArchivoPruebas(nombre, base + entrada);
    }
}
