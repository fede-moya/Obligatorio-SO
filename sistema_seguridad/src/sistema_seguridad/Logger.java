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
    private final String nombre;
    
     
        
    public Logger(String nombre){
        this.nombre = nombre;
        this.log("Simulacion iniciada");
    }
    public void log(String entrada){
        String base = "| Momento: " +Reloj.getInstance().getMomentoActual() + "|| ";
        ManejadorArchivos.escribirArchivo(nombre,base + entrada);
    }
    public static Logger getInstancia(){
        return instancia;
    }
    
    
     
}