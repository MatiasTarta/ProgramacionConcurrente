package TP5.Ej2;

public class Animal extends Thread {
    char tipo;
    Comedero comedero;

    public Animal(char t, Comedero c) {
        tipo = t;
        comedero = c;
    }

    public void run() {
        try {
            if (tipo == 'G') {
                comedero.comerGatos();
                System.out.println("Un gato ha comido.");
            } else {
                comedero.comerPerros();
                System.out.println("Un perro ha comido.");
            }
            Thread.sleep(2000); // Simula el tiempo de comer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
