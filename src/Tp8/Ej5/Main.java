package Tp8.Ej5;

public class Main {
    public static void main(String[] args) {
        Fogata fogataTribu = new Fogata(5);
        Cocinero hannibal = new Cocinero(0, fogataTribu);
        hannibal.start();
        Canibal[] papua = new Canibal[14];

        for (int i = 0; i < papua.length; i++) {
            papua[i] = new Canibal(i + 1, fogataTribu);
        }
        for (int i = 0; i < papua.length; i++) {
            papua[i].start();
        }
    }

}
