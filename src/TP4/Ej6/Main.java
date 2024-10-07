package TP4.Ej6;

public class Main {
    public static void main(String[] args) {
        Taxi navezota = new Taxi();
        Cliente pasajero = new Cliente(navezota);
        Taxista arjona = new Taxista(navezota);

        Thread hilo1 = new Thread(pasajero);
        Thread hilo2 = new Thread(arjona);

        hilo1.start();
        hilo2.start();
    }
}
