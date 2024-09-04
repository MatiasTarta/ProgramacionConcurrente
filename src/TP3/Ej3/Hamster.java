package TP3.Ej3;

public class Hamster extends Thread {
    public String nombre;
    Jaula jaulita;

    public Hamster(String n, Jaula j) {
        nombre = n;
        jaulita = j;
    }

    public void run() {
        System.out.println("Hola soy el hamster: " + nombre);
        jaulita.comer(nombre);
        jaulita.correr(nombre);
        jaulita.dormir(nombre);
    }

}
