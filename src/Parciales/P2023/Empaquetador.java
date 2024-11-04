package Parciales.P2023;

public class Empaquetador extends Thread {
    private Planta planta;

    public Empaquetador(Planta p) {
        planta = p;
    }

    public void run() {
        while (true) {
            try {
                planta.empaquetar();
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
