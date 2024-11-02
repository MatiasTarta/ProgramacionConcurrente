package Tp8.Ej3;

import java.util.concurrent.ThreadLocalRandom;

public class Empaquetador extends Thread {
    Pasteleria pasti;

    public Empaquetador(Pasteleria p) {
        pasti = p;
    }

    public void run() {
        while (true) {
            int peso;
            try {
                peso = pasti.tomarPastel();
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);
                pasti.soltarPastel(peso);
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
