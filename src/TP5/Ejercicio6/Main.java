package TP5.Ejercicio6;

public class Main {
    public static void main(String[] args) {
        Pista pista= new Pista(5);
        Avion aviones[]= new Avion[40];
        for(int i=0;i<aviones.length;i++){
            if(i==11 || i== 9 || i==35 ||i==13 || i==27){
                aviones[i]=new Avion("Despegue "+i, 'D', pista);
            }else{
               aviones[i]=new Avion("Aterrizaje "+i, 'A', pista);
            }
        }


        for(int i=0;i<aviones.length;i++){
            aviones[i].start();
        }
    }
}
