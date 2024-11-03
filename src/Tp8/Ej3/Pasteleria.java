package Tp8.Ej3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Pasteleria {
    int caja, pesoA, pesoB, pesoC, pesoMax;
    private Semaphore semaforoCaja, semaforoBrazo;

    public Pasteleria() {
        caja = 0;
        pesoA = 20;
        pesoB = 30;
        pesoC = 35;
        pesoMax = 100;
        semaforoCaja = new Semaphore(1);
        semaforoBrazo = new Semaphore(0);
    }

    public void retirarCaja() throws InterruptedException {
        semaforoBrazo.acquire();// cuando se llena una caja se hace un release a este semaforo para que el hilo
        // que lo invoca pueda retirar una caja
        if (caja > 0) {
            System.out.println("Una caja es cerrada y enviada al mostrador.La caja pesa: " + caja);
            System.out.println("Se coloca una nueva caja");
            caja = 0;// este seria el modulo reponer caja
        } else {
            System.out.println("ERROR NO HAY CAJA");
        }
        semaforoCaja.release();
    }

    public int tomarPastel() throws InterruptedException {

        int pesoSeleccionado = switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> pesoA;
            case 1 -> pesoB;
            case 2 -> pesoC;
            default -> throw new IllegalStateException("Unexpected value");
        };
        System.out.println("Uno de los brazos toma un pastel de peso: " + pesoSeleccionado);
        return pesoSeleccionado;
    }

    public void soltarPastel(int peso) throws InterruptedException {
        semaforoCaja.acquire();
        if (caja >= 0) {
            if ((caja + peso) <= pesoMax) {
                System.out.println("Uno de los brazos coloca un pastel en la caja.");
                caja += peso;
                System.out.println("Peso Actual: " + caja);
                semaforoCaja.release();
            } else {
                semaforoBrazo.release();// primero deja que se ponga una nueva caja
                semaforoCaja.acquire();// no va a seguir hasta que el brazo retire la caja y ponga una nueva
                System.out.println("Uno de los brazos coloca un pastel en la caja.");
                caja += peso;
                System.out.println("Peso Actual: " + caja);
                semaforoCaja.release();
            }
        }
    }

}
