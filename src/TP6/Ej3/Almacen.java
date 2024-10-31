package TP6.Ej3;

public class Almacen {
    int capacidadMaxima, inventario;

    public Almacen(int capacidad) {
        inventario = 0;
        capacidadMaxima = capacidad;
    }

    public synchronized void producir() throws InterruptedException {
        while (capacidadMaxima == inventario) {
            this.wait();
        }
        inventario++;
        System.out.println("El productor agrega un paquete al stock,quedan " + inventario + " productos");

        notifyAll();
    }

    public synchronized void consumir() throws InterruptedException {
        while (inventario == 0) {
            this.wait();

        }
        inventario--;
        System.out.println("Me llevo unas pitusas,quedan " + inventario + " productos");
        notify();
    }

}
