/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

/**
 *
 * @author federico
 */
public class Imagen {
    String idCamara; 
    // Representa la cantidad de momentos que necesita el ProcesadorImagen para procesar esta imagen
    Integer tiempoProcesamiento;
    // Representa el momento en que la imagen ingresa al sistema, este atributo 
    // debe ser modificado unicamente por una instancia de la clase GrupoCamara
    Integer momentoGeneracion;
    // representa el momento en el que la imagen fue retirada del buffer de imagenes, para ser p
    // procesada
    Integer momentoLeida;
    
}
