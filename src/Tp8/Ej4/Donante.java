package Tp8.Ej4;

import java.util.concurrent.ThreadLocalRandom;

public class Donante extends Thread {
    private int id;
    private Centro centro;

    public Donante(int id, Centro centro) {
        this.id = id;
        this.centro = centro;
    }

    @Override
    public void run() {
        try {
            // El donante entra al centro y realiza acciones en función de los recursos
            // disponibles
            centro.entrar(id);

            // Simula tiempo de espera mientras el donante lee o mira la televisión
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));

            // El donante pasa a donar cuando hay una camilla disponible
            centro.donar(id);

            // Simula el tiempo de donación de sangre
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));

            // Finaliza la donación y pasa al desayuno
            centro.terminarDonacion(id);
            System.out.println("El donante " + id + " desayuna antes de salir del centro.");

        } catch (InterruptedException e) {
            System.out.println("El donante " + id + " fue interrumpido: " + e.getMessage());
        }
    }
}
