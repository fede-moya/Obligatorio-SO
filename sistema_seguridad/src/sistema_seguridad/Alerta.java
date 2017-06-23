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
public class Alerta {
    private Delincuente persona;
    private Imagen requerido;
    
    // representa el momento en que se creo la alerta
    private Integer momentoGeneracion;
    // representa el momento en que se recibio la alerta
    private Integer momentoNotificada;
    

    public Delincuente getPersona() {
        return persona;
    }

    public void setPersona(Delincuente persona) {
        this.persona = persona;
    }

    public Imagen getRequerido() {
        return requerido;
    }

    public void setRequerido(Imagen requerido) {
        this.requerido = requerido;
    }

    public Integer getMomentoGeneracion() {
        return momentoGeneracion;
    }

    public void setMomentoGeneracion(Integer momentoGeneracion) {
        this.momentoGeneracion = momentoGeneracion;
    }

    public Integer getMomentoNotificada() {
        return momentoNotificada;
    }

    public void setMomentoNotificada(Integer momentoNotificada) {
        this.momentoNotificada = momentoNotificada;
    }

    public Alerta(Imagen requerido,Delincuente persona, Integer momentoGeneracion) {
        this.requerido = requerido;
        this.momentoGeneracion = momentoGeneracion;
        this.persona = persona;
    }
    
}
