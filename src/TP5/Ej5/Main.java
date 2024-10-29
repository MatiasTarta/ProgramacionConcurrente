package TP5.Ej5;

public class Main {
    public static void main(String[] args) {
        Tren diesel = new Tren(5);
        Maquinista sergio = new Maquinista(diesel);
        Pasajero personitas[] = new Pasajero[20];
        sergio.start();
        for (int i = 1; i < personitas.length; i++) {
            personitas[i] = new Pasajero(diesel);
            personitas[i].start();
        }
    }
}
