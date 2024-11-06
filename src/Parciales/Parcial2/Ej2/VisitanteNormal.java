package Parciales.Parcial2.Ej2;

import java.util.Random;

public class VisitanteNormal extends Thread {
    private final Parque parque;
    private final Random rand = new Random();

    public VisitanteNormal(Parque parque) {
        this.parque = parque;
    }

    @Override
    public void run() {
        try {
           
                parque.entrarVisitante();
                Thread.sleep(rand.nextInt(6000) + 1000); // Tiempo aleatorio entre 1 y 6 segundos
                parque.salir();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Visitante interrumpido: " + e.getMessage());
        }
    }
}