package BarberoDormilon;

public class Barbero implements Runnable {
    Barberia eljony;

    public Barbero(Barberia b) {
        eljony = b;
    }

    public void run() {
        while (true) {
            // es un while true porque el barbero permanece vivo siempre, no termina su
            // ciclo de vida
            try {
                eljony.dormir();// duerme hasta que un cliente lo despierta
                System.out.println("Ya me desperte jefazo te corto");
                // si el programa continua es porque un cliente lo desperto
                Thread.sleep(4000);
                System.out.println("Quedo flama");
                eljony.cobrar();// indica la salida al cliente
                System.out.println("Ahora a dormir una siestonga");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
