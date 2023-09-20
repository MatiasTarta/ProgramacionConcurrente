package TP4.Ejercicio3;

public class Main {
    
    public static void main(String[] args) {
        // Código a ejecutar
        Hilo P1= new Hilo('1', 2);
        Hilo P2= new Hilo('2', 4);
        Hilo P3= new Hilo('1', 6);
        Hilo P4= new Hilo('3', 3);
        
        P2.start();
        P1.start();
        P3.start();
        P4.start();
    }
}
