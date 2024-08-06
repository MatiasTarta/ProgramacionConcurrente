package TP8.Ejercicio2;

import java.util.Random;

public class Persona extends Thread {
    Observatorio observatorio;
    Random random;
    public Persona(String nombre,Observatorio obs){
        super(nombre);
        observatorio= obs;
        random= new Random();
    }

    public void run(){
        String nombre= Thread.currentThread().getName();
        try {
            if(nombre.contains("Mantenimiento")){
                while (true) {
                    observatorio.entrarMantenimiento();
                    Thread.sleep(15000);
                    observatorio.salir();
                    Thread.sleep(15000);
                }
            } else if(nombre.contains("Investigador")){
                observatorio.entrarInvestigador();
                
            }else{
                observatorio.entrarSala();
                
            }
                Thread.sleep(random.nextInt(10)*(1000));
                observatorio.salir();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
