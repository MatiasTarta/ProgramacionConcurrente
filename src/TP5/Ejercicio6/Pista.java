package TP5.Ejercicio6;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class Pista {
    private Semaphore semPista;
    
    private int despegues;
    private int aterrizaje;
    private Random random = new Random();
    public Pista(){
        semPista=new Semaphore(1);
        
    }

    public void despegar(int num){
        try{
            semPista.acquire();
            System.out.println("El vuelo "+num +" esta Despegando");
            Thread.sleep((random.nextInt(8) + 1)*1000);
            System.out.println("El vuelo "+num +" despego");
            System.out.println("La pista se encuentra libre");
            semPista.release();
            despegues++;
        }catch(InterruptedException ex){
        }
    }
    public void aterrizar(int num){
        try{
            
            semPista.acquire();
            System.out.println("El vuelo "+num +" esta aterrizando");
            Thread.sleep((random.nextInt(8) + 1)*1000);
            System.out.println("El vuelo "+num +" aterrizo");
            System.out.println("La pista se encuentra libre");
            semPista.release();
            aterrizaje++;
        }catch(InterruptedException ex){
        }
    }
}
