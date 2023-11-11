package TP8.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Observatorio {
    private int capacidad,cantPersonas,investigador,personal;
    private Lock lockSala;
    private Condition estaVacia;

    public Observatorio(int capacidad){
        this.capacidad=capacidad;
        cantPersonas=0;
        lockSala= new ReentrantLock();
        investigador=0;
        estaVacia=lockSala.newCondition();
        personal=0;
    }


    public void entrarSala()throws InterruptedException{
        try {
            lockSala.lock();
            while (cantPersonas>capacidad || investigador>0) {
                 estaVacia.await();
            }
            if(Thread.currentThread().getName().contains("Lisiado")){
                System.out.println("Un lisiado entro, capacidad de la sala reducida");
                this.capacidad=5;
            }
            System.out.println(Thread.currentThread().getName()+" entro a la sala y esta mirando las estrellas");
            cantPersonas++;
        } catch (Exception e) {
        }finally{
            lockSala.unlock();
        }
    }

    public void salir()throws InterruptedException{
        try {
            lockSala.lock();
            System.out.println(Thread.currentThread().getName()+ " salio de la sala");
            cantPersonas--;
            if(Thread.currentThread().getName().contains("Lisiado")){
                System.out.println("El lisiado se fue, capacidad de sala restablecida");
                this.capacidad=10;
            }
            if(Thread.currentThread().getName().contains("Personal")){
                personal--;
                cantPersonas++;
                //si el que salio era alguiien del personal reestablece el valor de la variable cantPersonas que anteriormente se redujo
            }
            if(Thread.currentThread().getName().contains("Investigador")){
                investigador--;
                cantPersonas++;
            }
            estaVacia.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lockSala.unlock();
        }
    }

    public void entrarMantenimiento()throws InterruptedException{
        lockSala.lock();
        while (cantPersonas>0 || investigador>0) {
            estaVacia.await();
        }
        System.out.println(Thread.currentThread().getName()+" esta realizando tareas de mantenimiento");
        personal++;
        lockSala.unlock();
    }
    public void entrarInvestigador(){
        try {
            lockSala.lock();
            while (personal>0 || cantPersonas>0 || investigador>0) {
                estaVacia.await();
            }
            System.out.println(Thread.currentThread().getName()+" esta investigando el cosmos");
            investigador++;
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lockSala.unlock();
        }
    }

}
