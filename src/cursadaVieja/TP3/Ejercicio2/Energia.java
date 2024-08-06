package TP3.Ejercicio2;

public class Energia {
    private static int energia = 10;

    public void modificar(int valor){
        energia+= valor;
    }
    public int getValor(){
        return energia;
    }
}
