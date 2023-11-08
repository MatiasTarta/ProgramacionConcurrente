package TP6.Ejercicio2;

public class Sala {
    private int  mesas,mesasEnuso;

    public Sala(int cantidadMesas) {
        mesas = cantidadMesas;
        mesasEnuso=0;
    }

    public synchronized void entrar() throws InterruptedException {
        while (mesas == mesasEnuso) {
             System.out.println(Thread.currentThread().getName()+" debe esperar");
            wait();
           
        }
        // el estudiante ocupa mesa
         System.out.println(Thread.currentThread().getName()+ " se sento");
       mesasEnuso++;
    }

    public synchronized void salir() {
        System.out.println( Thread.currentThread().getName()+" se fue de la sala");
        mesasEnuso--;
        this.notify();
    }
}
