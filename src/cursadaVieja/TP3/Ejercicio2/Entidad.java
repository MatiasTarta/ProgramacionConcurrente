package TP3.Ejercicio2;

public class Entidad implements Runnable  {
    int efecto;
    Energia energia;
    public Entidad(int drena,Energia energia){
        this.efecto=drena;
        this.energia=energia;
    }
    public int getDrena(){
        return efecto;
    }
    public synchronized void run(){
        while(energia.getValor()>0 && energia.getValor()<100){
            energia.modificar(efecto);
            System.out.println(Thread.currentThread().getName() + " :curo 3 de vida.Energia actual "+energia.getValor());
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                System.err.println("Se ha producido una InterruptedException: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}
