package Parcial.Ej1;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Planta {
    private int cajaA,cajaV,almacen;
    private Semaphore semPlanta,semEspera,semTransporte,semEmpaquetador;
    Random ran;
    public Planta(){
        cajaA=0;
        cajaV=0;
        almacen=0;
        semPlanta= new Semaphore(1);
        semEspera= new Semaphore(0);
        semTransporte= new Semaphore(0);
        semEmpaquetador= new Semaphore(0);
        ran= new Random();
    }

    public void embotellar(char tipo)throws InterruptedException{
        semPlanta.acquire();
        if(tipo=='V'){
            cajaV++;
            System.out.println("Se pone una botella de Vino en la caja,CajaVino: "+cajaV);
            if(cajaV==10){
                
                semEmpaquetador.release();
                semEspera.acquire();
                cajaV=0;
            }
        }else if(tipo=='A'){
            cajaA++;
            System.out.println("Se pone una botella de Agua Saborizada en la caja.Caja Agua: "+cajaA);
            if(cajaA==10){
                semEmpaquetador.release();
                semEspera.acquire();
                cajaA=0;
            }
        }
        semPlanta.release();
    }

    public void empaquetar()throws InterruptedException{
        semEmpaquetador.acquire();
        System.out.println("El empaquetador esta sellando una caja");
        Thread.sleep(ran.nextInt(10)*1000);
        almacen++;
        System.out.println("Caja enviada al almacen. Almacen: "+almacen);

        if(almacen==10){
            semTransporte.release();
        }
        semEspera.release();
    }
    public void transportar()throws InterruptedException{
        semTransporte.acquire();
        System.out.println("Sale un camion cargado de 10 cajas");
        almacen=0;
    }
}
