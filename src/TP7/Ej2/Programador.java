package TP7.Ej2;

import java.util.concurrent.ThreadLocalRandom;

public class Programador extends Thread {
    private Oficina oficina;
    private int id;

    public Programador(Oficina oficina, int id) {
        this.oficina = oficina;
        this.id = id;
    }

    @Override
    public void run() {

        try {

            // El programador intenta trabajar
            oficina.trabajar(id);
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 1000);
            // El programador decide descansar
            oficina.descanasar(id);

            // Espera un tiempo aleatorio entre 0 y 9 segundos antes de intentar trabajar de
            // nuevo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
