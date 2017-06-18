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
public class Logger {
    
    public static Logger instancia = null;
    private String nombre;
        
    public Logger(String nombre){
        this.nombre = nombre;
        // Crear archivo para la simulacion
        
        
        
    }
    
    public static Logger getInstancia(){
        return instancia;
    }
    
    
     
}
