package BarberoDormilon;

import java.util.concurrent.Semaphore;

public class Barberia {
    public Semaphore semSillon = new Semaphore(2);
    public Semaphore semBarbero = new Semaphore(0);
    public Semaphore sillon = new Semaphore(1);
    public Semaphore salida = new Semaphore(0);

    public void dormir() throws InterruptedException {
        semBarbero.acquire();// metodo que el barbero usa para descansar
    }

    public void despertarBarbero() {
        semBarbero.release();// metodo que el cliente usa para despertar barbero
    }

    public void cobrar() throws InterruptedException {
        salida.release();// metodo del barbero para indicar la salida
    }

    public void sentarse() throws InterruptedException {
        sillon.acquire();// el cliente se sienta
    }

    public void levantarse() {
        sillon.release();// termina el corte de pelo del cliente y se levanta
    }

    public void pagar() throws InterruptedException {
        salida.acquire();// el cliente le paga al barbero para irse
    }

    public void sentarseAEsperar() throws InterruptedException {
        semSillon.acquire();
    }

    public void liberarSillonEspera() {
        semSillon.release();
    }

}
