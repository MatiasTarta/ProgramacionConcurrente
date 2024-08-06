package TP4.Ejercicio4;

import java.util.concurrent.Semaphore;

public class Impresora extends Semaphore {

    private boolean disponible;
    private char tipo;

    public Impresora(int permits, boolean disponible,char tipo) {
        super(permits);
        this.disponible = disponible;
        this.tipo=tipo;
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
    public char getTipo(){
        return tipo;
    }
}
