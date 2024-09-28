package TP4.Ej5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {
    int numero;
    boolean ocupada;
    private Semaphore sem;
    private Random random; // Declarar un objeto Random

    public Impresora(int num) {
        numero = num;
        ocupada = false;
        sem = new Semaphore(1);
        random = new Random();
    }

    public int getNum() {
        return numero;
    }

    public boolean libre() {
        return !ocupada;
    }

    public void usar() throws InterruptedException {
        ocupada = true;
        sem.acquire();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " USANDO IMPRESORA " + this.getNum());
        System.out.println("Imprimiendo...");

        // Generar un número aleatorio entre 1 y 9
        int tiempoImpresion = random.nextInt(9) + 1; // Esto da un número entre 1 y 9
        Thread.sleep(1000 * tiempoImpresion); // Duerme el hilo el tiempo deseado

        sem.release();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " LIBERA IMPRESORA " + this.getNum());
        ocupada = false;
    }
}
