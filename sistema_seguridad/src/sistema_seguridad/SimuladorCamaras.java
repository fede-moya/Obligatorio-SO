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
import java.util.Queue;


/**
 *
 * @author federico
 */
public class SimuladorCamaras implements Runnable {

    public SimuladorCamaras(String tribuna) {
        this.tribuna = tribuna;
    }
    
    private final String tribuna;
    

    @Override
    public void run() {
        
        switch(tribuna){
            case "Amsterdam":
                capturarImagenes("Amsterdam10.csv",Buffers.amsterdam.getImagenes());
                break;
            case "Colombes":
                capturarImagenes("Colombes10.csv",Buffers.colombes.getImagenes());
                break;
            case "Olimpica":
                capturarImagenes("Olimpica10.csv",Buffers.olimpica.getImagenes());
                break;
            case "America":
                capturarImagenes("America10.csv",Buffers.america.getImagenes());
                break;
            case "Especiales":
                capturarImagenes("CamarasEspeciales10.csv",Buffers.especiales.getImagenes());
                break;
        }
        
    }
    
    public void capturarImagenes(String nombreArchivo,Queue<Imagen> imagenes){
        int capturadas = 0;
        FileReader fr;
        BufferedReader br;
        String[] linea;
        try {
            fr = new FileReader(nombreArchivo);
            br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            lineaActual = br.readLine();
            while (lineaActual != null) {
                capturadas++;
                if (capturadas == 5) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        System.out.println("Error tratando de dormir el hilo de la tribuna" + this.tribuna);
                    }
                    capturadas = 0;
                }
                linea = lineaActual.split(",");
                imagenes.add(new Imagen(linea[0],linea[1],Integer.parseInt(linea[2])));
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
