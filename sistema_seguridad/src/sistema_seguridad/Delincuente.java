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
public class Delincuente {
    
    String nombre;
    Integer ci;
    String codigoCara;

    public Delincuente(String nombre, Integer ci, String codigoCara) {
        this.nombre = nombre;
        this.ci = ci;
        this.codigoCara = codigoCara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public String getCodigoCara() {
        return codigoCara;
    }

    public void setCodigoCara(String codigoCara) {
        this.codigoCara = codigoCara;
    }
    
    
    
}
