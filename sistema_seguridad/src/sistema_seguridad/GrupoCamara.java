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
    String numero;
    Queue<Imagen> queue;

    public String getNumero() {
        return numero;
    }

    public GrupoCamara(String numero) {
        this.numero = numero;
        this.queue = new LinkedList<Imagen>();
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
