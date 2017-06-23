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
public class BaseDatos {
    
    private  static Map<String,String> codigosImagenes;
    private  static Map<String,Delincuente> delincuentes;
    private  static Map<String,Camara> prioridadCamaras;
    
    public static void cargarDatos(){
        codigosImagenes = new HashMap();
        delincuentes = new HashMap();
        prioridadCamaras = new HashMap();
        
        // Inicializa el hash delincuentes
        String[] datos = ManejadorArchivos.leerArchivo("Delincuentes.csv", true);
        if(datos.length > 0)
        {
            for(String dato : datos)
            {
                String[] atributos = dato.split(",");
                delincuentes.put(atributos[3],new Delincuente(atributos[0],atributos[1],Integer.parseInt(atributos[2]),atributos[3]));
            }
        }
        
        // Inicializa el hash codigosImagenes
        String[] codigoImagenesPatrones = ManejadorArchivos.leerArchivo("CodigoImagenPatron.csv", true);     
        for (int i = 0; i < codigoImagenesPatrones.length; i++) {
            String[] codigoPatron = codigoImagenesPatrones[i].split(",");
            codigosImagenes.put(codigoPatron[0], codigoPatron[1]);
        }
        
        // Inicializa el hash prioridadCamaras
        String[] camarasLeidas = ManejadorArchivos.leerArchivo("PrioridadCamaras.csv", true);
        if(camarasLeidas.length > 0)
        {
            for(String camara : camarasLeidas)
            {
                String[] atributos = camara.split(",");
                prioridadCamaras.put(atributos[0],new Camara(atributos[0],Integer.parseInt(atributos[1])));
            }
        }
    }

    public static Delincuente esDelincuente(Imagen imagen) throws IOException{
        String patron = codigosImagenes.get(imagen.getCodigo());
        Delincuente delincuente = null;
        if (patron!=null){
            delincuente = delincuentes.get(patron);
        }
        return delincuente;
    }
    
    public static int getPrioridadCamara(String idCamara){
        return prioridadCamaras.get(idCamara).getPrioridad();
    }
}
