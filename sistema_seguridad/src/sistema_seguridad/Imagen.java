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
    
    private String idImagen;
    
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

    public Imagen(String idCamara, String idImagen, Integer tiempoProcesamiento, 
            Integer prioridad) {
        this.idCamara = idCamara;
        this.idImagen = idImagen;
        this.tiempoProcesamiento = tiempoProcesamiento;
        this.prioridad = prioridad;
        this.tiempoEsperando = 0;
    }
    
    public String getIdCamara() {
        return idCamara;
    }
    
    public String getIdImagen() {
        return idImagen;
    }

    public Integer getTiempoEsperando() {
        return tiempoEsperando;
    }
    
    public void setTiempoEsperando(int tiempo) {
        this.tiempoEsperando = tiempo;
    }
    // representa el momento en el que la imagen fue retirada del buffer de imagenes, para ser p
    // procesada

    public void setIdCamara(String idCamara) {
        this.idCamara = idCamara;
    }

    public Integer getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    public Integer getMomentoGeneracion() {
        return momentoGeneracion;
    }
    
    public void setTiempoProcesamiento(Integer tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
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

    public Integer getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}