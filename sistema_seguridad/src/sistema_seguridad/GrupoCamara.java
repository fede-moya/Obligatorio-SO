/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author federico
 */
public class GrupoCamara {
    private String numero;
    private Queue<Imagen> imagenes;

    public String getNumero() {
        return numero;
    }

    public GrupoCamara(String numero) {
        this.numero = numero;
        this.imagenes = new LinkedList<Imagen>();
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Queue<Imagen> getImagenes() {
        return imagenes;
    }
    
    public Imagen getProximaImagen() {
        return imagenes.peek();
    }
    
    public Imagen eliminarImagen() {
        return imagenes.poll();
    }
}
