package TP6.Ejercicio1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class GestorTrafico {
    Queue<Integer> autosNorte;
    Queue<Integer> autosSur;
    int autosCruzaron;
    boolean norteCruzan;
    int autosMax = 5;
    int autosMin = 1;

    public GestorTrafico(){
        autosNorte= new LinkedList<>();
        autosSur=new LinkedList<>();
        norteCruzan=false;
    }

    public void entrar(char tipo,int id){
        if(tipo=='N'){
            try {
                entrarNorte(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(tipo=='S'){
            entrarSur(id);
        }
    }

    public void entrarNorte(int id) throws InterruptedException{
        synchronized (this) {
            while (autosCruzaron >= autosMax || (norteCruzan && autosCruzaron >= autosMin)) {
                wait();
            }
            autosNorte.add(id);
            System.out.println(id + " entro por el Norte");
            autosCruzaron++;
            Thread.sleep(new Random().nextInt(1000)); // Simulación de tiempo de espera y traslado
            if (norteCruzan && autosCruzaron >= autosMin) {
                norteCruzan = false;
            }
            notifyAll();
        }
    }

    public void entrarSur(int id){
        synchronized (this) {
            while (autosCruzaron >= autosMax || (!norteCruzan && autosCruzaron >= autosMin)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            autosSur.add(id);
            System.out.println(id + " entro por el Sur");
            autosCruzaron++;
            try {
                Thread.sleep(new Random().nextInt(1000)); // Simulación de tiempo de espera y traslado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!norteCruzan && autosCruzaron >= autosMin) {
                norteCruzan = true;
            }
            notifyAll();
        }
    }

    public synchronized void salirNorte(int id) throws InterruptedException{
        while(autosNorte.peek()!= id && !norteCruzan){
            wait();
        }
        autosNorte.remove();
        System.out.println(id+" salio por el norte");
        autosCruzaron--;
        notifyAll();
    }

    public synchronized void salirSur(int id)throws InterruptedException{
        while(autosSur.peek()!=id && norteCruzan){
            wait();
        }
        autosSur.remove();
        System.out.println(id+ " salio por el sur");
        autosCruzaron--;
        notifyAll();
    }
}

