package TP6.Ej7;

public class Automovil extends Thread {
    private Ferry ferry;

    public Automovil(Ferry ferry, String nombre) {
        super(nombre);
        this.ferry = ferry;
    }

    @Override
    public void run() {
        try {
            ferry.estacionar();
            ferry.desembarcar();
        } catch (InterruptedException e) {
            System.out.println("El automovil " + getName() + " fue interrumpido.");
        }
    }
}
