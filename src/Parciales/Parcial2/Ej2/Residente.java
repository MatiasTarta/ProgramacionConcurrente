package Parciales.Parcial2.Ej2;

import java.util.Random;

class Residente extends Thread {
    private final Parque parque;
    private final Random rand = new Random();

    public Residente(Parque parque) {
        this.parque = parque;
    }

    @Override
    public void run() {
        try {
                parque.entrarResidente();
                Thread.sleep(rand.nextInt(6000) + 1000); // Tiempo aleatorio entre 1 y 6 segundos
                parque.salir();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Residente interrumpido: " + e.getMessage());
        }
    }
}
