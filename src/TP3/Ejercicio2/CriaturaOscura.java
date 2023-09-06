package TP3.Ejercicio2;

public class CriaturaOscura extends Thread{
    private Energia energia;

    public CriaturaOscura(Energia energia){
        this.energia=energia;
    }

    public void run() {
        while(energia.getEnergia()<100 && energia.getEnergia()>0){
            System.out.println(Thread.currentThread().getName()+" :drenó 3 de Vida.Energia actual: "+energia.getEnergia());
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
                System.out.println("XD");
            }
            energia.drenar();
                }
    }
}
