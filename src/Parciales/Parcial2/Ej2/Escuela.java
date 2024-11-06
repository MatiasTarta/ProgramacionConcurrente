package Parciales.Parcial2.Ej2;

import java.util.Random;

class Escuela extends Thread {
    private final Parque parque;
    private final Random rand = new Random();

    public Escuela(Parque parque) {
        this.parque = parque;
    }

    @Override
    public void run() {
        try {
                parque.entrarEscuela();
                Thread.sleep(rand.nextInt(6000) + 1000); // Tiempo aleatorio entre 1 y 6 segundos
                parque.salirEscuela();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Escuela interrumpida: " + e.getMessage());
        }
    }
}
