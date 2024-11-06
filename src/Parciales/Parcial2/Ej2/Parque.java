package Parciales.Parcial2.Ej2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Parque {
    private int capacidadMax,escuelas,residentes,visitantes,cupo;
    Lock lockParque;
    Condition espacio;

    public Parque(int max,int c){
        capacidadMax=max;
        cupo=c;
        escuelas=0;
        residentes=0;
        visitantes=0;
        lockParque= new ReentrantLock();
        espacio= lockParque.newCondition();
    }
    public void entrarVisitante()throws InterruptedException{
        
        lockParque.lock();
        try {
            while (capacidadMax==visitantes || escuelas>0 || residentes>0) {
                espacio.await();//si no hay espacio, hay escuelas esperando o hay residentes el visitante normal espera
            }
            visitantes++;
            System.out.println("Entro un visitante. hay "+visitantes+" chabones");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lockParque.unlock();
        }
    }

    public void salir() {
        lockParque.lock(); // Adquirir el bloqueo antes de modificar variables compartidas y llamar a signalAll
        try {
            visitantes--;
            System.out.println("Un visitante y/o residente salió");
            System.out.println("Quedan: " + visitantes + " visitantes");
            espacio.signalAll(); // Notificar a otros hilos esperando en el Condition
        } finally {
            lockParque.unlock(); // Asegurar la liberación del bloqueo
        }
    }

    public void entrarResidente()throws InterruptedException{
        residentes++;
        lockParque.lock();
        try {
            
            while (capacidadMax==visitantes || escuelas>0 ) {
                espacio.await();}
            visitantes++;
            residentes--;
            System.out.println("Entro un residente. hay "+visitantes+" chabones");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lockParque.unlock();
        }
    }

    public void entrarEscuela()throws InterruptedException{
        escuelas++;

        lockParque.lock();
        try {
            while ((cupo+visitantes)>=capacidadMax) {
                espacio.await();
            }
            
            if(escuelas==1){
                capacidadMax-=cupo;
            }
            escuelas--;
            visitantes+=cupo;
            System.out.println("Entro una escuela. hay "+visitantes+" chabones");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lockParque.unlock();
        }
    }

    public void salirEscuela()throws InterruptedException{
        lockParque.lock();
        try {
            visitantes-=cupo;
        System.out.println("Se va una escuela: Visitantes= "+visitantes);
        espacio.signalAll();
        if(escuelas==0){
            capacidadMax+=cupo;
        }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{lockParque.unlock();}
    }




}
