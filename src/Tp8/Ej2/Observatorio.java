package Tp8.Ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int capacidad, cantPersonas;
    private Lock lockVisitantes;
    private Condition visitantes;
    private boolean mantenimiento, investigadores;

    public Observatorio() {
        capacidad = 50;
        cantPersonas = 0;
        lockVisitantes = new ReentrantLock();
        visitantes = lockVisitantes.newCondition();
        mantenimiento = false;
        investigadores = false;
    }

    public void entraVisitante(int i) {

        try {
            lockVisitantes.lock();
            while (capacidad == cantPersonas && !mantenimiento) {
                visitantes.await();
            }
            cantPersonas++;
            System.out.println("Visitante " + i + " -Entro a la sala");
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lockVisitantes.unlock();
        }
    }

    public void salirVisitante(int i) {
        try {
            lockVisitantes.lock();
            cantPersonas--;
            System.out.println("Visistante " + i + " -se marcho");
            visitantes.notifyAll();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lockVisitantes.unlock();
        }
    }

}
