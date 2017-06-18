package sistema_seguridad;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejadorArchivos {

    /**
     * @param nombreCompletoArchivo
     * @param listaLineasArchivo lista con las lineas del archivo
     * @throws IOException
     */
//    public static void escribirArchivo(String nombreCompletoArchivo,
//            String[] listaLineasArchivo) {
//        FileWriter fw;
//        try {
//            fw = new FileWriter(nombreCompletoArchivo, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            for (int i = 0; i < listaLineasArchivo.length; i++) {
//                String lineaActual = listaLineasArchivo[i];
//                bw.write(lineaActual);
//                bw.newLine();
//            }
//            bw.close();
//            fw.close();
//        } catch (IOException e) {
//            System.out.println("Error al escribir el archivo "
//                    + nombreCompletoArchivo);
//            e.printStackTrace();
//        }
//    }
    
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
