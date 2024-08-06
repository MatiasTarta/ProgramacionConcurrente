package TP8.Ejercicio1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        Comedor comedor= new Comedor(10, 5, 3);
        Soldado peloton[]= new Soldado[100];
        for(int i=0;i<peloton.length;i++){
            boolean postre=random.nextBoolean();;
            boolean gaseosa=random.nextBoolean();;
            peloton[i]= new Soldado("Soldado "+i, comedor, postre, gaseosa);
        }

        for(int i=0;i<peloton.length;i++){
    
            peloton[i].start();
        }
    }
}
