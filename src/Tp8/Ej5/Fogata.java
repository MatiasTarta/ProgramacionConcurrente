package Tp8.Ej5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fogata {
    int capacidadOlla, porciones;
    Lock lockOlla;
    Condition ollaVacia; // Usado para que los caníbales esperen a que haya comida
    Condition cocineroCondicion; // Usado para que el cocinero espere a que la olla esté vacía

    public Fogata(int n) {
        capacidadOlla = n;
        porciones = n; // La olla empieza llena
        lockOlla = new ReentrantLock();
        ollaVacia = lockOlla.newCondition();
        cocineroCondicion = lockOlla.newCondition();
    }

    public void comer(int i) throws InterruptedException {
        lockOlla.lock();
        try {
            while (porciones == 0) {
                cocineroCondicion.signal(); // Despierta al cocinero para que cocine
                ollaVacia.await(); // El caníbal espera a que la olla se llene
            }
            porciones--;
            System.out.println("El caníbal Nº" + i + " come de la olla, quedan " + porciones + " porciones.");
            if (porciones == 0) {
                cocineroCondicion.signal(); // Despierta al cocinero cuando se acaban las porciones
            }
        } finally {
            lockOlla.unlock();
        }
    }

    public void cocinar() throws InterruptedException {
        lockOlla.lock();
        try {
            while (porciones > 0) {
                cocineroCondicion.await(); // El cocinero espera hasta que la olla esté vacía
            }
            porciones = capacidadOlla; // Llena la olla
            System.out.println("El cocinero cocina una tanda de raciones. La olla queda llena.");
            ollaVacia.signalAll(); // Notifica a los caníbales en espera que la olla está llena
        } finally {
            lockOlla.unlock();
        }
    }
}
