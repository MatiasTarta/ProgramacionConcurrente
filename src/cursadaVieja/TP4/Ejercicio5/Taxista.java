package TP4.Ejercicio5;



public class Taxista extends Thread {
    private Taxi taxi;
    public Taxista(Taxi miNave){
        taxi= miNave;
    }

    public void run() {
        while(true) {
            try {
                taxi.iniciarRecorrido();
                System.out.println("El Taxista arranco el recorrido");
                Thread.sleep(1000);
                System.out.println("El Taxista termino el recorrido");
                taxi.finalizarRecorrido();
            } catch (Exception ex) {
            }
        }
    }
}
