package Parcial.Ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Recipiente {
    private int o,h,agua,capacidad,constante;
    private Lock lock;
    private Condition hayAgua,vaciar;
    private boolean oxListo,hidListo;

    public Recipiente(int tamanio){
        o=0;
        h=0;
        agua=0;
        capacidad=tamanio;
        lock= new ReentrantLock();
        hayAgua=lock.newCondition();
        vaciar= lock.newCondition();
        oxListo=false;
        hidListo=false;
        constante=0;
    }

    public void oListo()throws InterruptedException{
        lock.lock();
        o++;
        while(o<1 || h<2){
            hayAgua.await();
        }
        oxListo=true;
        hacerAgua();
        lock.unlock();
    }

    public void hListo()throws InterruptedException{
        lock.lock();
        h++;
        while(o<1 || h<2){
            hayAgua.await();
        }
        hidListo=true;
        hacerAgua();
        lock.unlock();
    }

    public void hacerAgua(){
        constante++;
        lock.lock();
        agua++;
        h=h-2;
        o--;
        System.out.println("Cantidad de agua "+agua);
        vaciar.notify();
        hayAgua.notify();
        lock.unlock();
    }
   

    public void vaciar()throws InterruptedException{
        lock.lock();
        while ((agua<capacidad)) {
            vaciar.await();
        }
        System.out.println("Se vacia el recipiente y se envasa el agua");
        agua=0;
    }

}
