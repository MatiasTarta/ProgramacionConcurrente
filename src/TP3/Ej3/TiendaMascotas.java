package TP3.Ej3;

public class TiendaMascotas {
    public static void main(String[] args) {
        Jaula jaula1 = new Jaula();
        Hamster mascotas[] = new Hamster[6];

        for (int i = 0; i < mascotas.length; i++) {
            mascotas[i] = new Hamster("Hamster " + (i + 1) + " ", jaula1);
        }

        for (int i = 0; i < mascotas.length; i++) {
            mascotas[i].start();
        }
    }
}
