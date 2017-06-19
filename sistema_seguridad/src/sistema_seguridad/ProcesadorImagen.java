/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author federico
 */
public class ProcesadorImagen implements Runnable {

    private Map<String,String> codigosImagenes;
    public ProcesadorImagen() {
        this.codigosImagenes = new HashMap();
        String[] codigoImagenesPatrones = ManejadorArchivos.leerArchivo("CodigoImagenPatron.csv", true);
        String[] codigoPatron;
        for (int i = 0; i < codigoImagenesPatrones.length; i++) {
            codigoPatron = codigoImagenesPatrones[i].split(",");
            codigosImagenes.put(codigoPatron[0], codigoPatron[1]);
        }
    }
    @Override
    public void run() {
        Imagen imagen = Buffers.imagenesAProcesar.peek();
        procesar(imagen);
    }
    
    public void procesar(Imagen imagen){
        String patron = codigosImagenes.get(imagen.codigo);
    }
    
}
