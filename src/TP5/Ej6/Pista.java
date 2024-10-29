package TP5.Ej6;

import java.util.concurrent.Semaphore;

public class Pista {
    int aterrizajes;
    public Semaphore semaforoPista, semaforoDespegue;

    public Pista() {
        semaforoPista = new Semaphore(1);
        semaforoDespegue = new Semaphore(0);
        aterrizajes = 0;
    }

    public void aterrizar() throws InterruptedException {
        semaforoPista.acquire();
    }

    public void entrarHangar() {
        aterrizajes++;
        semaforoPista.release();
    }

    public void intentarDespegue() throws InterruptedException {
        semaforoDespegue.acquire();
    }

    public void despegar() {
        semaforoDespegue.release(1);
        System.out.println("DESPEGUE");
        semaforoPista.release();
    }

    public void priorizarDespegue() {
        semaforoDespegue.release(1);

        aterrizajes = 0;
    }

    public int getAterrizajes() {
        return aterrizajes;
    }

    public void detenerAterrizajes() throws InterruptedException {
        semaforoPista.acquire();
        System.out.println("MOMENTOOO");
    }

    public void retomar() {
        semaforoPista.release();
    }

    public boolean forzarDespegue() {
        return aterrizajes >= 2;
    }
}
