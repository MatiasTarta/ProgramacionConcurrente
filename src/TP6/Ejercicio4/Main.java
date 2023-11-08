package TP6.Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Almacen deLaEsquina = new Almacen(5);
        Productor ernesto = new Productor(deLaEsquina);
        Consumidor[] clientes = new Consumidor[9];

        for(int i=0;i<clientes.length;i++){
            clientes[i]= new Consumidor("Cliente "+i,deLaEsquina);
        }
        ernesto.start();
        for(int i=0;i<clientes.length;i++){
            clientes[i].start();
        }
    }
}
