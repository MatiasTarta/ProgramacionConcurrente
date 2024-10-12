package TP5.Ej2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Comedero {
    char tipoAnimal;
    Semaphore semPerros;
    Semaphore semGatos;
    Random random = new Random();
    int permisos;

    public Comedero(int permisos) {
        this.permisos = permisos;
        semPerros = new Semaphore(0);
        semGatos = new Semaphore(0);
        if (random.nextInt(2) == 0) {
            tipoAnimal = 'G';
            System.out.println("hoy empiezan los gatos");
            semGatos.release(permisos); // Liberar permisos para gatos

        } else {
            tipoAnimal = 'P';
            System.out.println("hoy empiezan comiendo los perros");
            semPerros.release(permisos); // Liberar permisos para perros
        }

    }

    public void comerGatos() throws InterruptedException {
        if (semGatos.tryAcquire()) {
            // si puedo comer le mando
            semGatos.acquire();
        } else {
            // si ya estan los platos ocupados dejo que coman los perros
            semPerros.release(permisos);
            System.out.println("Ahora comen los perros");
        }
    }

    public void comerPerros() throws InterruptedException {
        if (semPerros.tryAcquire()) {
            semPerros.acquire();
        }
        {
            // si no puedo tomar el permiso cambio y dejo que coman los gatos
            semGatos.release(permisos);
            System.out.println("Ahora comen los gatos");
        }
    }
}