package Tp8.Ej4;

import java.util.concurrent.Semaphore;

public class Centro {
    private Semaphore camillas;
    private Semaphore revistas;
    private Semaphore sillas;

    public Centro() {
        camillas = new Semaphore(4);
        revistas = new Semaphore(9);
        sillas = new Semaphore(10);
    }

    public void entrar(int id) {
        try {
            }
        }catch(

    Exception e)
    {
        System.out.println("Error al entrar: " + e.getMessage());
    }
    }

    public void donar(int id) throws InterruptedException {
        // Espera hasta que haya una camilla disponible
        camillas.acquire();
        System.out.println("El donante " + id + " fue llamado a donar, deja su silla y revista si tenía.");
        sillas.release();
        revistas.release();
    }

    public void terminarDonacion(int id) {
        System.out.println("El donante " + id + " terminó de donar y ahora puede desayunar.");
        camillas.release(); // Libera la camilla
    }
}
