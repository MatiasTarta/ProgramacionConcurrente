package TP4.Ejercicio3;

public class Main {
    
    public static void main(String[] args) {
        // Código a ejecutar
        Hilo P1= new Hilo('1', 2);
        Hilo P2= new Hilo('2', 4);
        Hilo P3= new Hilo('3', 6);
        P1.start();
        P2.start();
        P3.start();
    }
}
