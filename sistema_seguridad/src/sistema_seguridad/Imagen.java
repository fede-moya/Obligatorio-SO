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
    private String idCamara;
    
    // Representa la cantidad de momentos que necesita el ProcesadorImagen para procesar esta imagen
    private Integer tiempoProcesamiento;
    // Representa el momento en que la imagen ingresa al sistema, este atributo 
    // debe ser modificado unicamente por una instancia de la clase GrupoCamara
    private Integer momentoGeneracion;
    // representa el momento en el que la imagen fue retirada del buffer de imagenes, para ser
    // procesada
    private Integer momentoLeida;

    private Integer prioridad;
    // tiempo que espera en cola para 
    private Integer tiempoEsperando;

    public Imagen(String idCamara, Integer tiempoProcesamiento, Integer momentoGeneracion, Integer momentoLeida, Integer prioridad) {
        this.idCamara = idCamara;
        this.tiempoProcesamiento = tiempoProcesamiento;
        this.momentoGeneracion = momentoGeneracion;
        this.momentoLeida = momentoLeida;
        this.prioridad = prioridad;
        this.tiempoEsperando = 0;
    }
    
    public String getIdCamara() {
        return idCamara;
    }

    public Integer getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    public Integer getMomentoGeneracion() {
        return momentoGeneracion;
    }

    public Integer getMomentoLeida() {
        return momentoLeida;
    }

    public Integer getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}