package TP4.Ejercicio3;

import java.util.concurrent.Semaphore;

public class RecursoCompartido {
    Semaphore mutexP1;
    Semaphore mutexP2;
    Semaphore mutexP3;

    public RecursoCompartido(){
        mutexP1= new Semaphore(1);
        mutexP2= new Semaphore(0);
        mutexP3= new Semaphore(0);
    }

    public void imprimir(int repeticiones,char caso) throws InterruptedException{
        switch (caso) {
            case '1':
                imprimir1(repeticiones);
            break;
                
            case '2':
                imprimir2(repeticiones);
            break;
                
            case '3':
                imprimir3(repeticiones);
            break;
        }
    }

    public void imprimir1(int repeticiones)throws InterruptedException{
        mutexP1.acquire();
        for(int i=1;i<=repeticiones;i++){
            System.out.println("Proceso1");
        }
        mutexP3.release();
    }
    public void imprimir2(int repeticiones) throws InterruptedException {
        mutexP2.acquire();
        for (int i = 1; i <= repeticiones; i++) {
            System.out.println("Proceso2");
        }
        mutexP1.release();
    }
    
    public void imprimir3(int repeticiones) throws InterruptedException {
        mutexP3.acquire();
        for (int i = 1; i <= repeticiones; i++) {
            System.out.println("Proceso3");
        }
        mutexP2.release();
    }
    
}
