package TP4.Ej6;

import java.util.concurrent.Semaphore;

public class Taxi {
    Semaphore semTaxista = new Semaphore(0);
    Semaphore semTaxi = new Semaphore(1);
    Semaphore semSalida = new Semaphore(1);

    public void despertarTaxista() {
        semTaxista.release();
    }

    public void dormir() throws InterruptedException {
        semTaxista.acquire();
    }

    public void subir() throws InterruptedException {
        semTaxi.acquire();
    }

    public void bajar() {
        semSalida.release();
    }

    public void cobrar() throws InterruptedException {
        semSalida.acquire();
    }

    public void pagar() {
        semSalida.release();
    }

}
