package TP6.Ej2;

public class Main {
    public static void main(String[] args) {
        Mesas mesi = new Mesas(7);
        Estudiante[] estudis = new Estudiante[20];

        for (int i = 0; i < estudis.length; i++) {
            estudis[i] = new Estudiante(mesi, i);
        }
        for (int i = 0; i < estudis.length; i++) {
            estudis[i].start();
        }

    }
}
