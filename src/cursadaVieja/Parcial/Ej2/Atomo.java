package Parcial.Ej2;

import java.util.Random;

public class Atomo  extends Thread{
    Recipiente rec;
    char tipo;
    Random ran= new Random();

    public Atomo(Recipiente r,char t){
        rec=r;
        tipo=t;
    }

    public void run(){
        
            try {
            if(tipo=='O'){
                System.out.println("Se agrega un atomo de oxigeno");
                rec.oListo();
            }else{
                System.out.println("Se agrega un atomo de hidrogeno");
                rec.hListo();
            }
            //Thread.sleep(2000*ran.nextInt(10));
        } catch (Exception e) {
        }
        
    }
}
