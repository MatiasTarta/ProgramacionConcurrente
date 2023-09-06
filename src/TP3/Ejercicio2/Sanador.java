package TP3.Ejercicio2;



public class Sanador extends Thread{
    private Energia energia;
    
    public Sanador(Energia energia){
        this.energia= energia;
    }

    public void run() {
        while(energia.getEnergia()<100 && energia.getEnergia()>0){
            System.out.println(Thread.currentThread().getName()+" :curó 3 e Vida.Energia actual: "+energia.getEnergia());
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
                System.out.println("XD");
            }
            energia.curar();
        }
    }
}
