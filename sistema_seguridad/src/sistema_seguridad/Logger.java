/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author federico
 */
public class Logger {
    
    public static Logger instancia = null;
    private final String nombre;
    
     
        
    public Logger(){
        String fecha = new SimpleDateFormat("dd_MM_HH_mm").format(new Date());
        this.nombre = "Simulaciones/"+ "Simulacion" + "_" + fecha;
        this.log("Simulacion iniciada");
    }
    public void log(String entrada){
        String base = "| Momento: " +Reloj.getInstance().getMomentoActual() + "|| ";
        ManejadorArchivos.escribirArchivo(nombre,base + entrada);
    }
    public static Logger getInstancia(){
        if (instancia == null) instancia = new Logger();
        return instancia;
    }
    
    
     
}