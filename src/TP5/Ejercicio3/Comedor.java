package TP5.Ejercicio3;

import java.util.concurrent.Semaphore;

public class Comedor {
    int capacidad,contadorPerros,contadorGatos,animales,i;
    Semaphore semComedor,semIngreso;
    char  tiposAnimales[],comederoActual;

    public Comedor(int capacidad,int animalitos){
        this.capacidad=capacidad;
        semComedor= new Semaphore(capacidad);
        semIngreso= new Semaphore(1);
        tiposAnimales= new char[2];
        tiposAnimales[0]='P';
        tiposAnimales[1]='G';
        i=0;

    }

    public void ingresar(char tipo) throws InterruptedException {
            semIngreso.acquire();
            if(tipo==comederoActual){
                //si es el turno de su tipo dejalo pasar
                 semIngreso.release();
                  comer(tipo);
            }else{
                Thread.sleep(5000);//espera el tiempo a que sea el turno de su tipo
                ingresar(tipo);
            }
               
        
    }

    public void comer(char tipo)throws InterruptedException{
        if(tipo==comederoActual){
           0
            semComedor.acquire();
            capacidad--;
            System.out.println(tipo+" "+Thread.currentThread().getName() +" esta comiendo");
            Thread.sleep(3000);
            System.out.println(tipo+" "+Thread.currentThread().getName() +" termino de comer");
            semComedor.release();
            capacidad++;
        }
    }
    

    public void cambiarTipo(){
        comederoActual= tiposAnimales[i];
        i++;
        System.out.println("El encargado cambio el tipo de comedero a "+ comederoActual);
        if(i>= tiposAnimales.length){
            i=0;
        }
    }

}
