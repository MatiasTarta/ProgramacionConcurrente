package TP4.Ejercicio5;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Taxista extends Thread {
    private Taxi taxi;
    public Taxista(Taxi miNave){
        taxi= miNave;
    }

    public void run() {
        while(true){
            try{
                taxi.dormir();
            }catch(InterruptedException ex){
                Logger.getLogger(Taxista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
