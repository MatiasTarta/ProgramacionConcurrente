package Parciales.P2023;

import java.util.concurrent.ThreadLocalRandom;

public class Embotellador extends Thread {
    private char tipo;
    private Planta planta;

    public Embotellador(char t, Planta p) {
        planta = p;
        tipo = t;
    }

    public void run() {
        while (true) {
            try {
                planta.embotellar(tipo);
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 400);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
