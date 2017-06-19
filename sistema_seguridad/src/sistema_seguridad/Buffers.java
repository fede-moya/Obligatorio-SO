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
public class Buffers {
    public static Queue<Imagen> imagenesAProcesar;
    public static Queue<Alerta> alertasANotificar;
    
    public static GrupoCamara amsterdam;
    public static GrupoCamara colombes;
    public static GrupoCamara paraliticos;
}