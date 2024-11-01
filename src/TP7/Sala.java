package TP7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sala {
    int maxVisitantes;
    int temperatura;
    int visitantes;
    int jubilados;
    int tUmbral;
    private Lock accesoSala;
    private Condition lugar;

    public Sala() {
        maxVisitantes = 50;
        accesoSala = new ReentrantLock();
        lugar = accesoSala.newCondition();
        tUmbral = 35;
        visitantes = 0;
        jubilados = 0;
        temperatura = 30;
    }

    public void notificarTemperatura(int t) {
        try {
            accesoSala.lock();
            temperatura = t;
            if (temperatura > tUmbral) {
                maxVisitantes = 35;
            } else {
                maxVisitantes = 50;
            }
            System.out.println("Temperatura Actual: " + temperatura + " Cº");
            System.out.println("Capacidad Maxima: " + maxVisitantes);

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            accesoSala.unlock();
        }
    }

    public void entrarSala() {
        try {
            accesoSala.lock();
            while ((visitantes >= maxVisitantes || jubilados == 0)) {
                lugar.await();
            }
            System.out.println(Thread.currentThread().getName() + " entro a la Sala");
            visitantes++;

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            accesoSala.unlock();
        }
    }

    public void salirSala() {
        try {
            accesoSala.unlock();

            System.out.println(Thread.currentThread().getName() + " salio de la Sala");
            visitantes--;
            lugar.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            accesoSala.unlock();
        }
    }

    public void entrarJubilado() {
        try {
            jubilados++;
            accesoSala.lock();
            while ((visitantes >= maxVisitantes)) {
                lugar.await();
            }
            System.out.println(Thread.currentThread().getName() + " entro a la Sala");
            jubilados--;
            visitantes++;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            accesoSala.unlock();
        }
    }
}
