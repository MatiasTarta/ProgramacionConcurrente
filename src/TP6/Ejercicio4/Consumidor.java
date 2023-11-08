package TP6.Ejercicio4;

public class Consumidor extends Thread {
    Almacen kiosco;
    
    public Consumidor(String nombre,Almacen kiosquito){
        super(nombre);
        kiosco=kiosquito;
    }

    public void run(){
        try {
            kiosco.consumir();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    
}
