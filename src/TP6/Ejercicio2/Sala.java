package TP6.Ejercicio2;

import java.util.Random;

public class Sala {
    private int mesas, mesasDisponibles, numAleatorio;
    Random random = new Random();

    public Sala(int cantidadMesas) {
        mesas = cantidadMesas;
        mesasDisponibles = cantidadMesas;
        numAleatorio = random.nextInt(10) + 1;
    }

    public synchronized void entrar(int id) throws InterruptedException {
        while (mesasDisponibles <= 0) {
            System.out.println(id+" debe esperar");
            wait();
        }
        // el estudiante ocupa mesa
         System.out.println(id + " se sento");
        mesasDisponibles--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
    }


    public void salir(int id) {
        System.out.println(id + " se fue de la sala");
        mesasDisponibles++;
        this.notify();
    }
}
