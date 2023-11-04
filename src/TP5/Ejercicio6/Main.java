package TP5.Ejercicio6;

public class Main {
    public static void main(String[] args) {
        Pista pista= new Pista(3);
        Avion aviones[]= new Avion[40];
        for(int i=0;i<aviones.length;i++){
            if(i==11 || i== 9 || i==35){
                aviones[i]=new Avion(i, 'D', pista);
            }else{
               aviones[i]=new Avion(i, 'A', pista);
            }
        }
        for(int i=0;i<aviones.length;i++){
            aviones[i].start();
        }
    }
}
