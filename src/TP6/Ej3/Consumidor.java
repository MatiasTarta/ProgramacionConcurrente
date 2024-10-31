package TP6.Ej3;

public class Consumidor extends Thread {
    Almacen a;

    public Consumidor(Almacen alma) {
        a = alma;
    }

    public void run() {
        try {
            a.consumir();
            // Thread.sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
