package TP5.Ejercicio2;

public class Empleado extends Thread{
    private Confiteria conf;
    public Empleado(Confiteria unaConf, String nombre){
        conf = unaConf;
        this.setName(nombre);
    }
    
    public void run(){
        try {
            conf.seSienta();
        } catch (InterruptedException ex) {
        }
        conf.avisarMozo();
        System.out.println(Thread.currentThread().getName() + " Llego a los Pollos Hermanos !!!");
        try {
            conf.comer();
        } catch (InterruptedException ex) {
        }
        System.out.println(Thread.currentThread().getName() +" comiendo");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        conf.liberaSilla();
    }
}