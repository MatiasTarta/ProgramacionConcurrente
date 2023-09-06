package TP3.Ejercicio2;

public class Energia {
    private static int energia = 10;

    public void drenar() {
        energia -= 3;
    }

    public void curar() {
        energia += 3;
    }
    public int getEnergia(){
        return energia;
    }
}
