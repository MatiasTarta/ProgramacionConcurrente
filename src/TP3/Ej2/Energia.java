package TP3.Ej2;

public class Energia {
    private int cantidad;

    public Energia(int cant) {
        cantidad = cant;
    }

    public void atacar(int valor) {
        cantidad += valor;
    }

    public int valorMana() {
        return cantidad;
    }
}
