package Tp2.Ej6;

import java.util.Random;

public class Corredor implements Runnable {
      private String nombre;
      private int pasos;
      private Random random;

    public Corredor(String nombre) {
        this.nombre = nombre;
        pasos=0;
         random = new Random();
    }

    public String getNombre(){
        return nombre;
    }
    
    public void run(){
       while (pasos<100) {
        int numeroAleatorio = random.nextInt(10) + 1;

        if(pasos+numeroAleatorio<=100){
            pasos+=numeroAleatorio;
        }
        System.out.println("El corredor " + nombre +" dio "+numeroAleatorio+ " pasos.Total Pasos-- "+pasos+" --" );
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){

        }

       }
       System.out.println(nombre+" Termino la carrera");
    }

     public static void main(String[] args) {
        // Crear instancias de corredores
        Corredor corredor1 = new Corredor("Usain Bolt");
        Corredor corredor2 = new Corredor("Correcaminos");
        Corredor corredor3 = new Corredor("Barry Allen");

        // Crear hilos para cada corredor
        Thread hilo1 = new Thread(corredor1);
        Thread hilo2 = new Thread(corredor2);
        Thread hilo3 = new Thread(corredor3);

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
       try{
        hilo1.join();
        hilo2.join();
        hilo3.join();
       }catch(InterruptedException e){
        System.out.println();
       }
        
    }
}
