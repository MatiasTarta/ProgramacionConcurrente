package TP5.Ejercicio6;

import java.util.Random;
import java.util.concurrent.Semaphore;
public class Pista {

    private Semaphore semPista;
    private Semaphore semAterrizajes;
    private int despegues;
    private boolean avionEsperando;
    private int contador;
    private int aterrizajesRestantes;
    private Random random = new Random();
    private Semaphore mutexUso;
    public Pista(int cantDespegues){
        semPista=new Semaphore(1);
        despegues= cantDespegues;
        semAterrizajes= new Semaphore(0);
        contador=0;
        avionEsperando=false;
        despegues=cantDespegues;
        aterrizajesRestantes=0;
        mutexUso = new Semaphore(1);
    }

    
      public void aterrizar(int avion) throws InterruptedException{
        semPista.acquire();
        System.out.println(avion+ " esta aterrizando");
        Thread.sleep(1000);
        System.out.println(avion+ "  aterrizo");
        contador++;
         semPista.release();
    }
     
    public void usarPista(char tipo,int avion)throws InterruptedException{
        mutexUso.acquire();
        try {
            
            if (tipo == 'A'  ) {
                if(contador<3){
                    aterrizar(avion);
                }else{
                    if(despegues>0){
                        priorizarDespegue(avion);
                    }else{
                         aterrizar(avion);
                    }
                }
            } else if (tipo == 'D' ) {
                despegar(avion);
            }
            mutexUso.release();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void priorizarDespegue(int avion) throws InterruptedException{
        semPista.acquire();
        avionEsperando=true;
        System.out.println("El avion "+avion+ " debe esperar a algun despegue");
        semPista.release();
         mutexUso.release();
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
   
}
