package TP8.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Pasteleria {
    Caja cajaActual;
    Cola mostrador;
    Semaphore semMostrador;
    public Pasteleria(){
        cajaActual=new Caja(10);
        mostrador=new Cola();
        semMostrador= new Semaphore(1);
    }


    public void ponerTorta(Torta tortita){
        mostrador.poner(tortita);
        System.out.println(Thread.currentThread().getName()+" coloca una Torta sobre el mostrador");
    }

    public void retirarCaja(){
        
    }
}
