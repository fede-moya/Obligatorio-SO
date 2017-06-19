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
    // representa el momento en el que la imagen fue retirada del buffer de imagenes, para ser p
    // procesada
    private Integer momentoLeida;

    public String getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(String idCamara) {
        this.idCamara = idCamara;
    }

    public Integer getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    public void setTiempoProcesamiento(Integer tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    public Integer getMomentoGeneracion() {
        return momentoGeneracion;
    }

    public void setMomentoGeneracion(Integer momentoGeneracion) {
        this.momentoGeneracion = momentoGeneracion;
    }

    public Integer getMomentoLeida() {
        return momentoLeida;
    }

    public void setMomentoLeida(Integer momentoLeida) {
        this.momentoLeida = momentoLeida;
    }

    public Imagen(String idCamara, Integer tiempoProcesamiento, Integer momentoGeneracion, Integer momentoLeida) {
        this.idCamara = idCamara;
        this.tiempoProcesamiento = tiempoProcesamiento;
        this.momentoGeneracion = momentoGeneracion;
        this.momentoLeida = momentoLeida;
    }
    
}
