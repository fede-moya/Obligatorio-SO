/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.*;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;

/**
 *
 * @author federico
 */
public class Logger {
    
    public static Logger instancia = null;
    private String nombre;
    
     
        
    public Logger(String nombre) throws IOException{
        this.nombre = nombre;
        this.log("Simulacion iniciada");
    }
    public void log(String entrada) throws IOException{
        String base = "| Momento: " +Reloj.getInstance().getMomentoActual() + "|| ";
        ManejadorArchivos.escribirArchivo(nombre,base + entrada);
    }
    public static Logger getInstancia(){
        return instancia;
    }
    
    
     
}