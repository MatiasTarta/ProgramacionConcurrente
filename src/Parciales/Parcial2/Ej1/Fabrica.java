package Parciales.Parcial2.Ej1;
import java.util.concurrent.Semaphore;

public class Fabrica{
    private int automovil;
    private Semaphore cajaRuedas,cajaPuertas,cajaCarroceria,ruedas,puertas,carroceria;
    public Fabrica(int capacidadRuedas,int capacidadPuertas, int capacidadCarroceria){
        automovil=0;
        cajaRuedas = new Semaphore(capacidadRuedas);
        cajaPuertas= new Semaphore(capacidadPuertas);
        cajaCarroceria= new Semaphore(capacidadCarroceria);
        ruedas=        new Semaphore(0);
        puertas = new Semaphore(0);
        carroceria= new Semaphore(0);
    }

    public void producirRuedas()throws InterruptedException{
        cajaRuedas.acquire();
        System.out.println("Equipo 1 produce una rueda");
        ruedas.release();
    }

    public void producirPuertas()throws InterruptedException{
        cajaPuertas.acquire();
        System.out.println("Equipo 2 produce una puerta");
        puertas.release();
    }

    public void producirCarroceria()throws InterruptedException{
        cajaCarroceria.acquire();
        System.out.println("Equipo 3 produce una carroceria");
        carroceria.release();
    }

    public void ensamblar()throws InterruptedException{
        carroceria.acquire();
        cajaCarroceria.release();
        puertas.acquire(2);
        cajaPuertas.release(2);
        ruedas.acquire(4);
        cajaRuedas.release(4);
        automovil++;
        System.out.println("Un Auto fue producido. Se hicieron "+automovil);
        if(automovil==5){
            System.out.println("5 Autoes son empaquetados");
            automovil=0;
        }
    }

}