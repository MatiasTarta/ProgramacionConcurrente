package TP7.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Oficina {
    private int notebooks,libros,notebooksLibres,librosLibres;
    private Condition hayNotebooks,hayLibros;
    private Lock lock;
    public Oficina(int cantNotebooks,int cantLibros){
        notebooks= cantNotebooks;
        libros=cantLibros;
        lock= new ReentrantLock();
        hayNotebooks= lock.newCondition();
        hayLibros= lock.newCondition();
        notebooksLibres=cantNotebooks;
        librosLibres=cantLibros;
    }

    public void usarLibro(){
        try {
            lock.lock();
            while(librosLibres<=0){
                System.out.println(Thread.currentThread().getName()+ " debe aguardar");
                hayLibros.await();
            }
            System.out.println(Thread.currentThread().getName()+ " agarro un libro");
            librosLibres--;

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void dejarLibro(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" termino de consultar el libro");
            librosLibres++;
            hayLibros.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void usarNotebook(){
        try {
            lock.lock();
            while(notebooksLibres<=0){
                System.out.println(Thread.currentThread().getName()+ " debe aguardar");
                hayNotebooks.await();
            }
            System.out.println(Thread.currentThread().getName()+ " agarro una Notebook");
            notebooksLibres--;

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

     public void dejarNotebook(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" termino de programar en la Notebook");
            notebooksLibres++;
            hayNotebooks.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }
}
