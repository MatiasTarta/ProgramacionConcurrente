package TP7.Ejercicio2;

import java.util.Random;

public class Programador extends Thread {
    Oficina theOffice;
     Random random ;
    public Programador(String nombre, Oficina oficina){
        super(nombre);
        theOffice= oficina;
        random= new Random();

    }
    public void run(){
        try {
            while (true) {
                if((random.nextInt(2) + 1)==2){
                    theOffice.usarLibro();
                    Thread.sleep(1500*(random.nextInt(2) + 1));
                    theOffice.dejarLibro();
                }else{
                    theOffice.usarNotebook();
                    Thread.sleep(1500*(random.nextInt(2) + 1));
                    theOffice.dejarNotebook();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
