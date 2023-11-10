package TP5.Ejercicio6;

import java.util.concurrent.Semaphore;

public class Pista {

    private Semaphore semPista;
    private Semaphore semAterrizajes;
    private Semaphore mutex;
    private int despegues;
    private boolean avionEsperando;
    private int contadorAterrizajes;
    private int aterrizajesRestantes;

    public Pista(int cantDespegues) {
        semPista = new Semaphore(1);
        despegues = cantDespegues;
        semAterrizajes = new Semaphore(0);
        contadorAterrizajes = 0;
        avionEsperando = false;
        aterrizajesRestantes = 0;
        mutex = new Semaphore(1);
    }

    public void usarPista(char tipoAvion) throws InterruptedException {
        mutex.acquire();
        if (tipoAvion == 'A') {
            if (contadorAterrizajes < 3) {
                // mientras que queden aterrizajes
                aterrizar();
            } else if (despegues() > 0){
                    // si quedan despegues por hacerse
                    priorizarDespegue();
                
            }
        } else if (tipoAvion == 'D') {
            // el avion despega
            despegar();
        }
    }

    public void aterrizar() throws InterruptedException {
        try {
            semPista.acquire();
            System.out.println(Thread.currentThread().getName() + " esta aterrizando");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " aterrizo");
            semPista.release();
            contadorAterrizajes++;
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.release();
        }

    }

    public void priorizarDespegue() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " debe esperar a algun despegue");
        avionEsperando = true;
        aterrizajesRestantes++;
        mutex.release();// dejo que otro avion use la pista(un despegue)
        semAterrizajes.acquire();
        aterrizar();
        aterrizajesRestantes--;
        avionEsperando = false;
    }

    public void despegar() throws InterruptedException {
        try {
            semPista.acquire();
            System.out.println(Thread.currentThread().getName() + " esta despegando");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " despego");
            despegues--;
            if (avionEsperando) {
                semAterrizajes.release();
            }
            if (despegues == 0) {
                System.out.println("No hay mas despegues el dia de hoy");
                semAterrizajes.release(aterrizajesRestantes);
            }
            contadorAterrizajes = 0;
            semPista.release();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            mutex.release();
        }

    }

    public int despegues() {
        return despegues;
    }

}
