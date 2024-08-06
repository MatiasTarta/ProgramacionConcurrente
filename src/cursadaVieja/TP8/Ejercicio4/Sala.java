package TP8.Ejercicio4;

public class Sala {
    private int camillasLibres,revistasLibres;

    public Sala(int camillas,int revistas){
        camillasLibres=camillas;
        revistasLibres=revistas;
    }


    public void donarSangre()throws InterruptedException{
        if(camillasLibres==0){
            sentarse();
        }
        System.out.println(Thread.currentThread().getName()+" esta Donando Sangre");
    }

    public void sentarse()throws InterruptedException{
        
    }
}
