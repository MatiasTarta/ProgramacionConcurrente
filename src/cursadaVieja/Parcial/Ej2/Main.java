package Parcial.Ej2;

import java.util.Random;

public class Main {
   public static void main(String[] args) {
     Recipiente r= new Recipiente(4);
     Atomo[] n= new Atomo[20];
    Random ran = new Random();
    for(int i=0;i<n.length;i++){
        if(ran.nextInt(2)%2==0){
            n[i]= new Atomo(r, 'O');

        }else{
            n[i]= new Atomo(r, 'H');
        }
    }

    Atomo h1= new Atomo(r, 'H');
    Atomo h2= new Atomo(r, 'H');
    Atomo o1= new Atomo(r, 'O');


    Atomo h3= new Atomo(r, 'H');
    Atomo h4= new Atomo(r, 'H');
    Atomo o2= new Atomo(r, 'O');
    h1.start();
    h2.start();
    o1.start();
    h3.start();
    h4.start();
    o2.start();
    
     for(int i=0;i<n.length;i++){
       
            n[i].start();

    }
     
   
   }
}
