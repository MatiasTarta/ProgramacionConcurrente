package TP5.Ej7;

public class Nadador extends Thread {
    Tobogan tobi;
    int nombre;

    public Nadador(Tobogan t, int i) {
        tobi = t;
        nombre = i + 1;
    }

    public void run() {
        try {
            tobi.subir();
            System.out.println("Nadador" + nombre + " subio 1 escalon");
            tobi.tirarse();
            Thread.sleep(3000);
            System.out.println("Nadador" + nombre + " se tiro por el tobogan");

            tobi.chapuzon();
            System.out.println("Nadador " + nombre + " salio de la pileta");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
