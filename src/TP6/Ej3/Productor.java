package TP6.Ej3;

public class Productor extends Thread {
    Almacen mercado;

    public Productor(Almacen a) {
        mercado = a;
    }

    public void run() {
        while (true) {
            try {
                mercado.producir();
                // Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
