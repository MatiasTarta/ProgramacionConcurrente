package TP4.Ej4;

import java.util.concurrent.Semaphore;

public class Impresora {
    int numero;
    boolean ocupada;
    private Semaphore sem;

    public Impresora(int num) {
        numero = num;
        ocupada = false;
        sem = new Semaphore(1);
        // creo el semaforo de cada impresora con 1 permiso
    }

    public int getNum() {
        return numero;
    }

    public boolean ocupar() throws InterruptedException {
        // la impresora esta ocupada
        sem.acquire();
        boolean exito = false;
        if (!ocupada) {
            sem.acquire();
            exito = true;
            ocupada = true;

            System.out.println("CLIENTE " + Thread.currentThread().getName() + " USANDO IMPRESORA " + this.getNum());
            System.out.println("Imprimiendo...");
        }
        sem.release();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " LIBERA IMPRESORA " + this.getNum());
        ocupada = false;
        return exito;

    }

}
