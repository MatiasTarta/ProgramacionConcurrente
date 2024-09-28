package TP4.Ej5;

public class Main {
    public static void main(String[] args) {
        GestorImpresoras gestor = new GestorImpresoras();

        // Crear un arreglo para los hilos
        Thread[] hilos = new Thread[9];
        for (int i = 0; i < 9; i++) {
            Cliente cliente = new Cliente("Cliente " + (i + 1), gestor);
            hilos[i] = new Thread(cliente);
            hilos[i].start();
        }
    }
}
