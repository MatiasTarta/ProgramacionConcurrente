package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore taxista;
    private Semaphore taxi;

    public Taxi(){
        taxi= new Semaphore(1);
        taxista= new Semaphore(0);
    }

    public void dormir() throws InterruptedException{
        taxi.acquire();
        //bloequea el taxiste
    }
    public void subirse() throws InterruptedException{
        despertar();
        taxi.acquire();

    }
    public void despertar(){
        taxi.release();
    }
    public void bajarse(){
        taxi.release();
    }
}
