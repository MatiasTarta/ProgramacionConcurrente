package TP5.Ejercicio1;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Pileta {
    private BlockingDeque<Integer> pileta;
    private Random random = new Random();

    public Pileta(int limite) {
        pileta = new LinkedBlockingDeque<>(limite);
    }

    public void dejarEntrar(int numero) throws InterruptedException {
        pileta.put(numero); // Colocar el número en la pileta
        System.out.println("La persona " + numero + " entró y se está bañando");
        Thread.sleep((random.nextInt(5) + 1) * 1000);
        salir(numero);
    }

    public void salir(int num) throws InterruptedException {
        
        System.out.println(num + " se está secando");
        Thread.sleep((random.nextInt(5) + 1) * 1000);
        System.out.println(num + " salió y se liberó un espacio");
        pileta.take(); // Sacar a la persona de la pileta
    }
}