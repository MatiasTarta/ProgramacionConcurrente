package TP4.Ejercicio5;

public class Main {
    public static void main(String[] args){
        Taxi nave= new Taxi();
        Taxista arjona = new Taxista(nave);
        Pasajero davor = new Pasajero("Dominik", nave);
        Pasajero membrillo = new Pasajero("Membrillo", nave);
        arjona.start();
        davor.start();
        membrillo.start();
    }
}
