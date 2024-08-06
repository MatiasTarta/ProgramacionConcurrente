package TP5.Ejericio7;

import java.util.concurrent.Semaphore;

public class Mirador {
    Semaphore tobogan, escalera,salida;
    private int personaEsprando,toboganEnUso;

    public Mirador(int personasEscalera) {
        tobogan = new Semaphore(2);
        escalera = new Semaphore(personasEscalera);
        personaEsprando = 0;
        toboganEnUso=0;
        salida= new Semaphore(2);
    }

    public void hacerBajar() throws InterruptedException {
        if (personaEsprando >= 2) {
           switch (toboganEnUso) {
            case 1:
                tobogan.release(1);
                break;
            case 0:
                tobogan.release(2);
            default:
                break;
           }
        }else if(personaEsprando==1){
            if(toboganEnUso==2){
                tobogan.release();
            }
        }
    }

    public void solicitarBajar() throws InterruptedException {
        escalera.acquire();// la persona (hilo) se sube a la escalera para hacer fila y tirarse por el // tobogan
        System.out.println(Thread.currentThread().getName() + " Esta esperando en la escalera");
    }

    public void usarTobogan()throws InterruptedException{
        personaEsprando++;
        tobogan.acquire();

        salida.acquire();
        toboganEnUso++;
        System.out.println(Thread.currentThread().getName()+" se esta tiro por el tobogan!!");
        salida.release();
    }
    public void salir()throws InterruptedException{
        salida.acquire();
        System.out.println(Thread.currentThread().getName()+" salio del tobogan");
        toboganEnUso--;
        salida.release();
    }

}
