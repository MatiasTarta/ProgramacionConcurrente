package TP4.Ejercicio5;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pasajero extends Thread {
    Taxi taxi;

    public Pasajero(Taxi ford){
        taxi=ford;
    }

    public void run(){
        try{
            taxi.subirse();
        }catch(InterruptedException ex){
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El wachin  se subio al Taxi");
        Thread.sleep(5000);
        //simula tiempo de viaje
        try{
            taxi.bajarse();//se baja
            System.out.println("Wachin se bajo");
        }catch (InterruptedException ez) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
