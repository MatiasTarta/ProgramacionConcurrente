package TP6.Ejercicio7;

public class Ferry {
    private int limiteAutos,limitePasajeros,pasajerosAcuales,autosActuales;


    public Ferry(int limiteCarros,int limitePersonas){
        limiteAutos=limiteCarros;
        limitePasajeros=limitePersonas;
        autosActuales=0;
        pasajerosAcuales=0;
    }

    public synchronized void abordar(char tipo)throws InterruptedException{
        if(tipo=='A'){
            while((limiteAutos<=autosActuales)){
                this.wait();
            }
            System.out.println(Thread.currentThread().getName()+" se subio al ferry");
            autosActuales++;
        }else if(tipo=='P'){
            while((limitePasajeros<=pasajerosAcuales)){
                this.wait();
            }
            System.out.println(Thread.currentThread().getName()+ " se subio al ferry");
            pasajerosAcuales++;
        }
    }

    public synchronized void bajar(){
        System.out.println("Bajan todos");
        pasajerosAcuales=0;
        autosActuales=0;
        this.notifyAll();
    }

    public void hacerRecorrido()throws InterruptedException{
        pasajerosAcuales=limitePasajeros;
        autosActuales=limiteAutos;
        System.out.println("El ferry comienza el recorrido");
        Thread.sleep(6700);
        System.out.println("El ferry termino el recorrido");
        bajar();
    }
}
