package TP6.Ejercicio4;

import java.util.Random;

public class Productor extends Thread{
    Almacen kiosco;
    Random r ;

    public Productor(Almacen kiosquito){
        kiosco=kiosquito;
        r= new Random();
    }

    public void run(){
        while (true) {
            try {
                kiosco.colocarProducto();
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
