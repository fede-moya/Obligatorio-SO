/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import static sistema_seguridad.ManejadorArchivos.leerArchivo;

/**
 *
 * @author federico
 */
public class SimuladorCamaras implements Runnable {

    public SimuladorCamaras(String tribuna) {
        this.tribuna = tribuna;
    }
    
    private String tribuna;
    

    @Override
    public void run() {
        switch(tribuna){
            case "Amsterdam":
                try {
                    capturarImagenes("Amsterdam.csv",Buffers.amsterdam.getImagenes());
                } catch (InterruptedException ex) {

                } catch (IOException ex) {
            
        }
break;
            case "Colombes":
                try {
            try {
                capturarImagenes("Colombes.csv",Buffers.colombes.getImagenes());
            } catch (IOException ex) {
                
            }
                } catch (InterruptedException ex) {
                    
                }break;
            case "Olimpica":
                try {
                    capturarImagenes("Olimpica.csv",Buffers.olimpica.getImagenes());
                } catch (InterruptedException ex) {
                    
                } catch (IOException ex) {

        }
break;
            case "America":
                try {
                    capturarImagenes("America.csv",Buffers.america.getImagenes());
                } catch (InterruptedException ex) {
                    
                } catch (IOException ex) {
            
        }
break;
            case "Especiales":
                try {
                    capturarImagenes("CamarasEspeciales.csv",Buffers.especiales.getImagenes());
                } catch (InterruptedException ex) {
                    
                } catch (IOException ex) {
            
        }
break;
                
            
        }
        
    }
    
    public void capturarImagenes(String nombreArchivo,Queue<Imagen> imagenes) throws InterruptedException, IOException{
        int capturadas = 0;
        FileReader fr;
        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            lineaActual = br.readLine();
            String[] linea = null;
            Imagen imagen = null;
            while (lineaActual != null) {
                capturadas++;
                if (capturadas == 5) {
                    Thread.sleep(1);
                    capturadas = 0;
                }
                linea = lineaActual.split(",");
                imagenes.add(new Imagen(linea[0],linea[1],Integer.getInteger(linea[2])));
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo"+ nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+ nombreArchivo);
        }
    
    }
    
    
}
