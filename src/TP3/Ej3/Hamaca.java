package TP3.Ej3;

public class Hamaca {
    public synchronized void usarHamaca(String nombre) {
        System.out.println("Hamster: " + nombre + "esta durmiendo ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Hamster: " + nombre + "TERMINO DE DORMIR ");
    }
}
