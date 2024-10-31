package TP5.Ej7;

public class Main {
    public static void main(String[] args) {
        Tobogan t = new Tobogan(5);
        Nadador[] nadadores = new Nadador[10];

        for (int i = 0; i < nadadores.length; i++) {
            nadadores[i] = new Nadador(t, i);
            nadadores[i].start();
        }
    }
}
