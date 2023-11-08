package TP6.Ejercicio4;

public class Main {
    public static void main(String[] args) {
        Almacen deLaEsquina = new Almacen(7);
        Productor ernesto = new Productor(deLaEsquina);
        Productor pampa = new Productor(deLaEsquina);
        Productor erick = new Productor(deLaEsquina);
        Consumidor[] clientes = new Consumidor[25];

        for(int i=0;i<clientes.length;i++){
            clientes[i]= new Consumidor("Cliente "+i,deLaEsquina);
        }
        ernesto.start();
        pampa.start();
        erick.start();
        for(int i=0;i<clientes.length;i++){
            clientes[i].start();
        }
        
    }
}
