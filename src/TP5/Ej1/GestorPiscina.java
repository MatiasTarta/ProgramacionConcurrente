package TP5.Ej1;

import java.util.concurrent.Semaphore;

public class GestorPiscina {
    Semaphore pileta;
    Semaphore salida;

    public GestorPiscina(int capacidad) {
        pileta = new Semaphore(capacidad);
        salida = new Semaphore(1);
    }

    public void entrar() throws InterruptedException {
        pileta.acquire();
    }

    public void salir() {
        pileta.release();
    }

    public void escalera() throws InterruptedException {
        salida.acquire();
    }

    public void secarse() {
        salida.release();
    }
}
