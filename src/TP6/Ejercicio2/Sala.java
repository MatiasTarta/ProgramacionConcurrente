package TP6.Ejercicio2;

import java.util.Random;

public class Sala {
    private int  mesasDisponibles;
    Random random = new Random();

    public Sala(int cantidadMesas) {
        mesasDisponibles = cantidadMesas;
    }

    public synchronized void entrar(int id) throws InterruptedException {
        while (mesasDisponibles <= 0) {
            wait();
            System.out.println(id+" debe esperar");
        }
        // el estudiante ocupa mesa
         System.out.println(id + " se sento");
        mesasDisponibles--;
        try {
            Thread.sleep(random.nextInt(10)*(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
    }


    public void salir(int id) {
        System.out.println(id + " se fue de la sala");
        mesasDisponibles++;
        this.notifyAll();
    }
}
