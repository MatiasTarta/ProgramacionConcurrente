package TP5.Ejercicio1;

public class Main {
    public static void main(String[] args){
        Pileta pileta=new Pileta(5);
        GestorPileta gestor = new GestorPileta(pileta);

         Nadador[] nadadores = new Nadador[20];
        for (int i = 0; i < 20; i++) {
            nadadores[i]= new Nadador(gestor, i+1);
            nadadores[i].start();
        }
    }
}
