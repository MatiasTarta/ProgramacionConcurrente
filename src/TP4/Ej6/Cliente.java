package TP4.Ej6;

public class Cliente implements Runnable {
    Taxi nave = new Taxi();

    public Cliente(Taxi tachi) {
        nave = tachi;
    }

    public void run() {
        try {
            nave.subir();
            System.out.println("Llega un nuevo pasajero al taxi");
            nave.despertarTaxista();
            Thread.sleep(3000);
            nave.pagar();
            System.out.println("El pasajero le paga al tachero");
            nave.bajar();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
