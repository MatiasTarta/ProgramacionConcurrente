package Parciales.P2023;

public class Transportador extends Thread {
    private Planta planta;

    public Transportador(Planta p) {
        planta = p;
    }

    public void run() {
        while (true) {
            try {
                planta.transportar();
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
