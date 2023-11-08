package TP6.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Puente pasoCordoba = new Puente();
        Auto[] turistas= new Auto[17];
        for(int i=0;i<turistas.length;i++){
           if(i==1 || i==4 || i==9 | i==7){
             turistas[i]= new Auto(pasoCordoba, 'N', "Auto "+i);
           }else{
             turistas[i]= new Auto(pasoCordoba, 'S', "Auto "+i);
           }
        }

        for(int i=0;i<turistas.length;i++){
            turistas[i].start();
        }
    }
}

