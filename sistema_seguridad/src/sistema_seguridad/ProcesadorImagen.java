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
    private Map<String,String[]> delincuentes;
    public ProcesadorImagen() {
        this.codigosImagenes = new HashMap();
        this.delincuentes = new HashMap();
        String[] codigoImagenesPatrones = ManejadorArchivos.leerArchivo("CodigoImagenPatron.csv", true);
        String[] codigoPatron;
        for (int i = 0; i < codigoImagenesPatrones.length; i++) {
            codigoPatron = codigoImagenesPatrones[i].split(",");
            codigosImagenes.put(codigoPatron[0], codigoPatron[1]);
        }
        
        String[] delincuentesData = ManejadorArchivos.leerArchivo("Delincuentes.csv", true);
        
        String patron;
        String[] aux;
        for (int i = 0; i < delincuentesData.length; i++) {
           aux = delincuentesData[i].split(","); 
           patron = aux[3];
            delincuentes.put(patron,aux);
        }
        
    }
    @Override
    public void run() {
        Imagen imagen = Buffers.imagenesAProcesar.peek();
        if (imagen!=null) procesar(imagen);
        
    }
    
    public void procesar(Imagen imagen){
        String patron = codigosImagenes.get(imagen.getCodigo());
        if (patron!=null){
            String[] delincuenteEncontrado = delincuentes.get(patron);
            Delincuente delincuente = new Delincuente(delincuenteEncontrado[0],Integer.getInteger(delincuenteEncontrado[1]),delincuenteEncontrado[3]);
            Alerta alerta  = new Alerta(imagen,delincuente,Reloj.getInstance().getMomentoActual());
            Buffers.alertasANotificar.add(alerta);
        }
    }
    
}