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
public class Simulador implements Runnable {

    public Simulador() {}

    @Override
    public void run() {
        iniciarNuevaSimulacion();
    }
    
    public void iniciarNuevaSimulacion(){
        Thread camarasAmsterdam = new Thread(new SimuladorCamaras("Amsterdam"));
        Thread camarasColombes = new Thread(new SimuladorCamaras("Colombes"));
        Thread camarasOlimpica = new Thread(new SimuladorCamaras("America"));
        Thread camarasAmerica = new Thread(new SimuladorCamaras("Olimpica"));
        Thread camarasEspeciales = new Thread(new SimuladorCamaras("Especiales"));
        
        camarasAmsterdam.start();
        camarasColombes.start();
        camarasOlimpica.start();
        camarasAmerica.start();
        camarasEspeciales.start();
    
    }
    
}
