/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_seguridad;

/**
 *
 * @author federico
 */
public class ReceptorImagen implements Runnable{

    @Override
    public void run() {
        Buffers.imagenesAProcesar.add(PlanificadorReceptor.getProximaImagen());
        System.out.println("Recibiendo imagen");
    }
    
}
