package TP6.Ej3;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(5);
        Productor sergio = new Productor(almacen);
        sergio.start();
        Consumidor[] clientela = new Consumidor[20];
        for (int i = 0; i < clientela.length; i++) {
            clientela[i] = new Consumidor(almacen);

        }
        for (int i = 0; i < clientela.length; i++) {
            clientela[i].start();
        }

    }
}
