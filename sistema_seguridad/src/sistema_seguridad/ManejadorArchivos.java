package sistema_seguridad;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico
 */
public class ManejadorArchivos {
    
    public static void escribirArchivo(String nombreArchivo,String texto) throws IOException{
        FileWriter simulacion = new FileWriter(nombreArchivo,true);
        PrintWriter pw = new PrintWriter(simulacion);
        pw.println(texto);
        simulacion.close();
    }
    
    public static String[] leerArchivo(String nombreCompletoArchivo, boolean ignoreHeader) {
        FileReader fr;
        ArrayList<String> listaLineasArchivo = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            if (ignoreHeader) lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }

        return listaLineasArchivo.toArray(new String[0]);
    }
    
    public static List<Imagen> leerImagenes(String nomArch, boolean ignoreHeader){
        List<Imagen> imagenes = new ArrayList<>();
        
        String[] imagenesLeidas = leerArchivo(nomArch, ignoreHeader);
        
        for (String linea: imagenesLeidas) {
            if ((linea != null) && (!linea.trim().equals(""))) {
                String[] datos = linea.split(";");
//                Imagen imagen = new Imagen(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
            
//                imagenes.add(imagen);
            }
        }
        return imagenes;
    }
}
