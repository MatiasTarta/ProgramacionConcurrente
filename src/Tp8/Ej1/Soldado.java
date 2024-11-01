package Tp8.Ej1;

import java.util.concurrent.ThreadLocalRandom;

public class Soldado extends Thread {
    boolean postre;
    boolean gaseosa;
    int nombre;
    Cuartel general;

    public Soldado(int n, boolean p, boolean g, Cuartel c) {
        postre = p;
        gaseosa = g;
        nombre = n + 1;
        general = c;
    }

    public void run() {
        try {
            {
                // System.out.println("Soldado Nº " + nombre + " entra al cuartel");
                general.servirse(nombre);
                if (gaseosa) {
                    general.abrirGaseosa(nombre);
                }
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);
                if (postre) {
                    general.servirsePostre(nombre);
                }
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);

                System.out.println("Soldado Nº " + nombre + " se fue a la guerra");

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
