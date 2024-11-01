package Tp8.Ej1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Cuartel {
    // Recursos compartidos: mostradorAlmuerzo gaseosa(opcional, requiere
    // abrelatas), postre(opcional mostrador postre)
    private Semaphore mostradorAlmuerzo, abrelatas, mostradorPostre;

    public Cuartel() {
        mostradorAlmuerzo = new Semaphore(5);
        abrelatas = new Semaphore(10);
        mostradorPostre = new Semaphore(3);
    }

    public void servirse(int i) throws InterruptedException {
        // un soldado entra al comedor y se sirve comida
        mostradorAlmuerzo.acquire();
        System.out.println("El soldado Nº " + i + " se sirve su almuerzo");

        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 500);
        mostradorAlmuerzo.release();
    }

    public void abrirGaseosa(int i) throws InterruptedException {
        abrelatas.acquire();
        System.out.println("EL soldado Nº " + i + " busca el abrelatas y abre su gaseosa");

        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 500);
        abrelatas.release();
    }

    public void servirsePostre(int i) throws InterruptedException {
        mostradorPostre.acquire();
        System.out.println("El soldado Nº " + i + " se sirve su postre");

        Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10) * 500);
        mostradorPostre.release();
    }
}
