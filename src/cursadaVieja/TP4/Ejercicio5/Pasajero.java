package TP4.Ejercicio5;

public class Pasajero extends Thread {
    Taxi taxi;
    String nombre;

    public Pasajero(String nombre, Taxi ford) {
        taxi = ford;
        this.nombre = nombre;
    }

    public void run() {
        try {
            taxi.subirseAlTaxi();
            System.out.println(nombre + " se subio al taxi");
            taxi.despertarTaxista();
            Thread.sleep(4000);
            taxi.bajarseDelTaxi();
            System.out.println(nombre+ " se bajo");
            taxi.dormirTaxista();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
