package BarberoDormilon;

public class Cliente implements Runnable {
    Barberia eljony;
    int nombre;

    public Cliente(Barberia b, int n) {
        eljony = b;
        nombre = n + 1;
    }

    @Override
    public void run() {
        try {
            eljony.sentarse();// una vez sentado el cliente despierta al barbero
            System.out.println("Desperta viejo meado");
            eljony.despertarBarbero();
            // System.out.println("Cliente N " + nombre + " pide un buzz cut");
            Thread.sleep(3000);
            eljony.pagar();// adquiere semaforo salida para irse a la goma
            System.out.println("Cliente N " + nombre + " se fue al boliche");
            eljony.levantarse();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}