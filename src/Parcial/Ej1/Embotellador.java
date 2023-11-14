package Parcial.Ej1;

import java.util.Random;

public class Embotellador extends Thread{
    char tipo;
    Planta planta;
    Random r;
    public Embotellador(char tipito,Planta plantita){
        tipo=tipito;
        planta=plantita;
        r= new Random();
    }

    public void run(){
        try {
            while (true) {
                planta.embotellar(tipo);
                Thread.sleep((r.nextInt(10)+1)*1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
