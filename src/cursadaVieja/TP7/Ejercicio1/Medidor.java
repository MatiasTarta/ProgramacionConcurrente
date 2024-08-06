package TP7.Ejercicio1;

public class Medidor  extends Thread{
    Sala museo;

    public Medidor(Sala museito){
        museo=museito;
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(3000);
                museo.cambiarTemperatura();
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
