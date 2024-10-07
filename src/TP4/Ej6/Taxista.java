package TP4.Ej6;

public class Taxista implements Runnable {

    Taxi nave = new Taxi();

    public Taxista(Taxi tachi) {
        nave = tachi;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("El taxista duerme");
                nave.dormir();
                System.out.println("El taxista se desperto!");
                System.out.println("Paraste el taxi indicado pibe");
                Thread.sleep(5000);
                nave.cobrar();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
