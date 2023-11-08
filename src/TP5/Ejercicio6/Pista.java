package TP5.Ejercicio6;

import java.util.concurrent.Semaphore;
public class Pista {

    private Semaphore semPista;
    private Semaphore semAterrizajes;
    private int despegues;
    private boolean avionEsperando;
    private int contador;
    private int aterrizajesRestantes;


    public Pista(int cantDespegues){
        semPista=new Semaphore(1);
        despegues= cantDespegues;
        semAterrizajes= new Semaphore(0);
        contador=0;
        avionEsperando=false;
        despegues=cantDespegues;
        aterrizajesRestantes=0;
    
    }

    
      public void aterrizar(int avion) throws InterruptedException{
        semPista.acquire();
        System.out.println(avion+ " esta aterrizando");
        Thread.sleep(1000);
        System.out.println(avion+ "  aterrizo");
        contador++;
        System.out.println(contador);
        semPista.release();
    }
     
   

    public void priorizarDespegue(int avion) throws InterruptedException{
        semPista.acquire();
        avionEsperando=true;
        System.out.println("El avion "+avion+ " debe esperar a algun despegue");
        semPista.release();
        //libera la pista para que otro la use
        aterrizajesRestantes++;
        semAterrizajes.acquire();
        System.out.println(avion+ " esta aterrizando");
        Thread.sleep(1000);
        //random.nextInt(10) + 1)*
         System.out.println(avion+ "  aterrizo");
         avionEsperando=false;
         contador++;
         aterrizajesRestantes--;
    }

    public void despegar(int avion) throws InterruptedException{
        semPista.acquire();
        System.out.println(avion+ " esta despegando");
        Thread.sleep(4000);
        System.out.println(avion+ "  despego");
        despegues--;
        semPista.release();
        if(avionEsperando){
            semAterrizajes.release();
            contador=0;
        }
        if(despegues==0){
            //condicional utoilizado en el ultimo despegue del dia para acomodar los aviones rezagados
            semAterrizajes.release(aterrizajesRestantes);
        }
    }

    public int contadorAterrizajes(){
        return contador;
    }
    public int contadorDespegues(){
        return despegues;
    }
   
}
