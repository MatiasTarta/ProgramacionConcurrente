package TP5.Ejercicio1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pileta {
    private Semaphore semDisponible;
    private Semaphore semEntradaSalida;
    private Random random = new Random();
    public Pileta(int limite) {
        this.semDisponible = new Semaphore(limite);
        this.semEntradaSalida= new Semaphore(1);
    }

    public void dejarEntrar(int numero) throws InterruptedException {
        semDisponible.acquire();
        System.out.println("La persona " + numero + " entro y se esta bañando");
        Thread.sleep((random.nextInt(5) + 1)*1000);
        salir(numero);

    }
    public void salir(int num) throws InterruptedException{
        semEntradaSalida.acquire();
        System.out.println(num+ " se esta Secando");
        Thread.sleep((random.nextInt(5) + 1)*1000);
        semEntradaSalida.release();
        System.out.println(num+ " salio y se libero un espacio");
         semDisponible.release();
    }

}
