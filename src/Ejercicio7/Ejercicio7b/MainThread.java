package Ejercicio7.Ejercicio7b;

import Ejercicio7.Cliente;

public class MainThread {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        // Crear instancias de los cajeros
        CajeroThread cajero1 = new CajeroThread("Cajero 1");
        CajeroThread cajero2 = new CajeroThread("Cajero 2");

        // Establecer los clientes para los cajeros
        cajero1.setCliente(cliente1);
        cajero2.setCliente(cliente2);

        // Crear hilos para los cajeros y comenzar su ejecución
        Thread threadCajero1 = new Thread(cajero1);
        Thread threadCajero2 = new Thread(cajero2);

        threadCajero1.start();
        threadCajero2.start();

        // Esperar a que ambos hilos terminen antes de continuar si es necesario
        try {
            threadCajero1.join();
            threadCajero2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
