package TP3.Ej3;

public class Rueda {
    public synchronized void usarRueda(String nombre) {
        System.out.println("Hamster: " + nombre + " esta corriendo ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("Hamster: " + nombre + "TERMINO DE CORRER ");
    }
}
