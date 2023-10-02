package ActividadObligatoria;

import java.util.concurrent.Semaphore;

public class Tren {
    
    private int capacidad;
    private int pasajeros;
    private Semaphore controlSubida; //para que no se suban 2 pasajeros al mismo tiempo
    
    private Semaphore enViaje;

    public Tren(){
        capacidad=2;
        pasajeros=0;
        controlSubida= new Semaphore(1, true);
        enViaje= new Semaphore(0);
    }

    public boolean subir(String nombre) throws InterruptedException{
        boolean sePudoSubir=false;
        //mutex para realizar subida atomica
        controlSubida.acquire();
        if (pasajeros == capacidad) {
            System.out.println("Tren lleno, comienza el Recorrido");
            //libera permiso para que el hiloControl empiece el viaje
            enViaje.release();
        }else{
            System.out.println(nombre + " abordo el Tren");
            pasajeros++;
            sePudoSubir=true;
            controlSubida.release();
        }
        return sePudoSubir;
    }

    public void recorrer() throws InterruptedException{
        enViaje.acquire();
        System.out.println("CHU CHUUU");
        Thread.sleep(2000);
        //finaliza el reocrrido
        pasajeros=0;
        //baja a todos los pasajeros
        
        System.out.println("Recorrido Finalizado");
        //libera el controlSubida para que otro pasajero se pueda subir
         controlSubida.release();
    }


}
