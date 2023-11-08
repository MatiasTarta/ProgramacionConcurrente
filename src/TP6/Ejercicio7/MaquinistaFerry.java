package TP6.Ejercicio7;

public class MaquinistaFerry extends Thread {
    Ferry barco;
    public MaquinistaFerry(Ferry barquito){
        barco=barquito;
    }
    public void run(){
        while (true) {
            try {
                Thread.sleep(400);
                barco.hacerRecorrido();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
