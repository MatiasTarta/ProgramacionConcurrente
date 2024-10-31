package TP6.Ej7;

public class ControlFerry extends Thread {
    private Ferry ferry;

    public ControlFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Esperar hasta que el ferry esté lleno
                ferry.hacerRecorrido();

                // Simular el tiempo del recorrido
                Thread.sleep(3000);

                // Finalizar el recorrido y permitir el desembarque
                ferry.finalizarRecorrido();
            }
        } catch (InterruptedException e) {
            System.out.println("El ControlFerry fue interrumpido.");
        }
    }
}
