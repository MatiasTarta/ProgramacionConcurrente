package BarberoDormilon;

public class Main {
    public static void main(String[] args) {
        Barberia elJoni = new Barberia();
        Barbero joni = new Barbero(elJoni);
        Cliente losVatos[] = new Cliente[9];
        Thread losVatosThread[] = new Thread[9];

        for (int i = 0; i < losVatos.length; i++) {
            losVatos[i] = new Cliente(elJoni, i + 1);
        }

        for (int j = 0; j < losVatosThread.length; j++) {
            losVatosThread[j] = new Thread(losVatos[j]);
        }

        for (int k = 0; k < losVatosThread.length; k++) {
            losVatosThread[k].start();
        }

        Thread barber = new Thread(joni);
        barber.start();
    }
}
