package TP5.Ej6;

public class Main {
    public static void main(String[] args) {
        Pista pista = new Pista();
        TorreControl torre = new TorreControl(pista);
        torre.start();
        for (int i = 0; i < 9; i++) {
            Avion avionA = new Avion(pista, 'A'); // Aviones que aterrizan
            avionA.start();
        }
        for (int i = 0; i < 5; i++) {
            Avion avionD = new Avion(pista, 'D'); // Aviones que despegan
            avionD.start();
        }
    }
}
