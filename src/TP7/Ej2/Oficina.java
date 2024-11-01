package TP7.Ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Oficina {
    int totalCompus, totalLibros, libros, compus;
    private Lock lockMaterial;
    private Condition hayMaterial;

    public Oficina(int c, int t) {
        totalCompus = c;
        totalLibros = t;
        libros = 0;
        compus = 0;
        lockMaterial = new ReentrantLock();
        hayMaterial = lockMaterial.newCondition();
    }

    public void trabajar(int n) {
        try {
            lockMaterial.lock();
            while (totalCompus == compus && totalLibros == libros) {
                hayMaterial.await();
            }
            System.out.println("EL programador " + n + " tomo un libro y una compu y se puso a trabajar");
            compus++;
            libros++;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lockMaterial.unlock();
        }
    }

    public void descanasar(int n) {
        try {
            lockMaterial.lock();
            System.out.println("El programador " + n + " se fue a descansar");
            compus--;
            libros--;

            hayMaterial.signal();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lockMaterial.unlock();
        }
    }
}
