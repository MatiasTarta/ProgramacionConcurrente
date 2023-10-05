package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;

public class Taxi {

    private Semaphore semLibre;//taxi
    private Semaphore semOcupado;//tachero
    private Semaphore semSalida;

    public Taxi() {
        semLibre = new Semaphore(1);
        semOcupado = new Semaphore(0);
        semSalida = new Semaphore(0);
    }
    
    public void subirseAlTaxi() throws InterruptedException {
        semLibre.acquire();
    }
    
    public void despertarTaxista() {
        System.out.println("El taxista dejo de seducir a la vida");
        semOcupado.release();
    }
    
    public void iniciarRecorrido() throws InterruptedException {
        semOcupado.acquire();
    }
    
    public void finalizarRecorrido() {
        semSalida.release();
    }
    
    public void bajarseDelTaxi() throws InterruptedException {
        semSalida.acquire();
    }
    
    public void dormirTaxista() {
        System.out.println("El taxista esta seduciendo a la vida");
        semLibre.release();
    }
}
