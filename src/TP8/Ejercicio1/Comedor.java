package TP8.Ejercicio1;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int abridores,mostradores,mostradorPostre;
    private Semaphore semMostrador,semAbridores,semPostre;

    public Comedor(int cantAbridores,int cantMostradores,int cantPostre){
        abridores=cantAbridores;
        mostradores=cantMostradores;
        mostradorPostre=cantPostre;
        semMostrador= new Semaphore(cantMostradores);
        semAbridores=new Semaphore(cantAbridores);
        semPostre=new Semaphore(cantPostre);
    }


    public void servirseComida(){
        try {
            semMostrador.acquire();
            System.out.println(Thread.currentThread().getName()+" esta sirviendose comida");
            Thread.sleep(3500);
            System.out.println(Thread.currentThread().getName()+" termino de servirse");
            semMostrador.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void comer()throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+" esta comiendo ");
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName()+" se fue");
    }
    public void abrirGaseosa()throws InterruptedException{
        try {
            semAbridores.acquire();
            System.out.println(Thread.currentThread().getName()+" esta abriendo su lata");
            Thread.sleep(4000);
            semAbridores.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void servirsePostre()throws InterruptedException{
        try {
            semPostre.acquire();
            System.out.println(Thread.currentThread().getName()+" esta sirviendose postre");
            semPostre.release();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
