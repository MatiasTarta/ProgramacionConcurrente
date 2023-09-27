package TP4.Ejercicio4;

import java.util.concurrent.Semaphore;

public class Impresora extends Semaphore {

    private boolean disponible;

    public Impresora(int permits, boolean disponible) {
        super(permits);
        this.disponible = disponible;
    }

    public boolean getDisponibilidad() {
        return disponible;
    }

    public void noDisponible() {
        this.disponible = false;
    }

    public void liberarDisponible() {
        this.disponible = true;
    }
}
