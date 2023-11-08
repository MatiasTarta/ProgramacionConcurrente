package TP6.Ejercicio4;

public class Productor extends Thread{
    Almacen kiosco;

    public Productor(Almacen kiosquito){
        kiosco=kiosquito;
    }

    public void run(){
        while (true) {
            try {
                kiosco.colocarProducto();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
