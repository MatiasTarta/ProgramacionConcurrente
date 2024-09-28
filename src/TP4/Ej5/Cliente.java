package TP4.Ej5;

public class Cliente implements Runnable {
    String nombre;
    GestorImpresoras gestor;

    public Cliente(String n, GestorImpresoras g) {
        this.nombre = n;
        gestor = g;
    }

    public void run() {
        // Aquí se debería manejar la impresión
        gestor.imprimir();
    }
}
