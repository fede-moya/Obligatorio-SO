package sistema_seguridad;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author federico
 */
public class ManejadorArchivos {
    
    public static void escribirArchivo(String nombreArchivo,String texto){
        FileWriter simulacion = null;
        try {
            simulacion = new FileWriter(nombreArchivo,true);
            PrintWriter pw = new PrintWriter(simulacion);
            pw.println(texto);
            simulacion.close();
        } catch (IOException ex) {
            System.out.println("Algo salio mal tratando de escribir el archivo "+ nombreArchivo);
        } finally {
            try {
                simulacion.close();
            } catch (IOException ex) {
                System.out.println("Algo salio mal tratando de cerrar el archivo "+ nombreArchivo);
            }
        }
    }
    
        public static void escribirArchivoPruebas(String nombreArchivo,String texto){
        FileWriter simulacion = null;
        try {
            simulacion = new FileWriter(nombreArchivo,true);
            PrintWriter pw = new PrintWriter(simulacion);
            pw.println(texto);
            simulacion.close();
        } catch (IOException ex) {
            System.out.println("Algo salio mal tratando de escribir el archivo "+ nombreArchivo);
        } finally {
            try {
                simulacion.close();
            } catch (IOException ex) {
                System.out.println("Algo salio mal tratando de cerrar el archivo "+ nombreArchivo);
            }
        }
    }

    
    public static String[] leerArchivo(String nombreCompletoArchivo, boolean ignoreHeader) {
        FileReader fr;
        BufferedReader br;
        ArrayList<String> listaLineasArchivo = new ArrayList<>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            if (ignoreHeader) lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo "+ nombreCompletoArchivo);
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
        }

        return listaLineasArchivo.toArray(new String[0]);
    }
}
