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

    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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

    public String getIdCamara() {
        return idCamara;
    }

    public Integer getTiempoEsperando() {
        return tiempoEsperando;
    }

    public void setTiempoEsperando(int tiempo) {
        if (this.tiempoEsperando + tiempo == 3) {
            this.tiempoEsperando = 0;
            setPrioridad(1);
        } else {
            this.tiempoEsperando = tiempo;
        }
    }

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


    public Imagen(String idCamara, String codigo, Integer tiempoProcesamiento) {
        this.idCamara = idCamara;
        this.codigo = codigo;
        this.tiempoProcesamiento = tiempoProcesamiento;
        this.prioridad = 4;
        this.tiempoEsperando = 0;
    }
    
    public Integer getPrioridad() {
        return prioridad;

    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad += prioridad;
    }
}
