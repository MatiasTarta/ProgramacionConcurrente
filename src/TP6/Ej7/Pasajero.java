package TP6.Ej7;

public class Pasajero extends Thread {
    private Ferry ferry;

    public Pasajero(Ferry ferry, String nombre) {
        super(nombre);
        this.ferry = ferry;
    }

    @Override
    public void run() {
        try {

            ferry.sentarse();
            ferry.bajar();
        } catch (InterruptedException e) {
            System.out.println("El pasajero " + getName() + " fue interrumpido.");
        }
    }
}
