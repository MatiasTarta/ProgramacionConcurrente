package TP5.Ej7;

import java.util.concurrent.Semaphore;

public class Tobogan {
    Semaphore tobogan;
    Semaphore escalera;

    public Tobogan(int cantidadEscalones) {
        tobogan = new Semaphore(2);
        escalera = new Semaphore(cantidadEscalones);
    }

    public void tirarse() throws InterruptedException {
        tobogan.acquire();
        escalera.release();
    }

    public void chapuzon() {
        tobogan.release();
    }

    public void subir() throws InterruptedException {
        escalera.acquire();
    }
}
