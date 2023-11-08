package TP5.Ejercicio6;

public class Main {
    public static void main(String[] args) {
        Pista pista= new Pista(3);
        Avion aviones[]= new Avion[40];
         TorreControl torreAlta= new TorreControl(pista);
        for(int i=0;i<aviones.length;i++){
            if(i==11 || i== 9 || i==35){
                aviones[i]=new Avion(i, 'D', torreAlta);
            }else{
               aviones[i]=new Avion(i, 'A', torreAlta);
            }
        }


        for(int i=0;i<aviones.length;i++){
            aviones[i].start();
        }
    }
}
