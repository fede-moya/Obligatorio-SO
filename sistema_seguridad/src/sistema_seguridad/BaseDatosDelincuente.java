/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author federico
 */
public class BaseDatosDelincuente {
    
    private  Map<String,String> codigosImagenes;
    private  Map<String,Delincuente> delincuentes;
    
    private static BaseDatosDelincuente instance = null;
    
    public static BaseDatosDelincuente getInstance(){
        if (instance ==null){
            instance = new BaseDatosDelincuente();
            instance.cargarDatos();
        }
        return instance;
    }  
    
    private void cargarDatos(){
        codigosImagenes = new HashMap();
        delincuentes = new HashMap();
        // inicializa el arraylist de delincuente
        String[] datos = ManejadorArchivos.leerArchivo("Delincuentes.csv", true);
        if(datos.length > 0)
        {
            for(String dato : datos)
            {
                String[] atributos = dato.split(",");
                delincuentes.put(atributos[3],new Delincuente(atributos[0],atributos[1],Integer.parseInt(atributos[2]),atributos[3]));
            }
        }
        
        String[] codigoImagenesPatrones = ManejadorArchivos.leerArchivo("CodigoImagenPatron.csv", true);     
        for (int i = 0; i < codigoImagenesPatrones.length; i++) {
            String[] codigoPatron = codigoImagenesPatrones[i].split(",");
            codigosImagenes.put(codigoPatron[0], codigoPatron[1]);
        }
    }

    public Delincuente esDelincuente(Imagen imagen) throws IOException{
        String patron = codigosImagenes.get(imagen.getCodigo());
        Delincuente delincuente = null;
        if (patron!=null){
            delincuente = delincuentes.get(patron);
        }
        return delincuente;
    }
}
