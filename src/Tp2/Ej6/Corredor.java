package Tp2.Ej6;

public class Corredor implements Runnable {
      private String nombre;
      private int pasos;

    public Corredor(String nombre) {
        this.nombre = nombre;
        pasos=0;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void run(){
       while (pasos<100) {
        int numeroAleatorio = random.nextInt(10) + 1;
        System.out.println("El corredor" + nombre +" dio "+numeroAleatorio+ " pasos" );
        pasos+=numeroAleatorio;
       }
    }
}
