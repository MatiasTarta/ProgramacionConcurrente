package Ejercicio7.Ejercicio7b;

import Ejercicio7.Cliente;

public class CajeroThread implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public CajeroThread(String nombre) {
        this.nombre = nombre;
    }

    // Constructor, y métodos de acceso
    public void setCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }

    public void run() {
        // Obtén el tiempo inicial antes de comenzar a procesar
        this.initialTime = System.currentTimeMillis();

        System.out.println("El cajero " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println(
                    "El cajero "+this.nombre+
                    " esta procesado el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + "->Tiempo: " +
                            (System.currentTimeMillis() - this.initialTime) / 1000
                            + "seg");
        }
        System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + this.cliente.getNombre()
                + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - this.initialTime) / 1000 +
                "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000); // Convierte segundos a milisegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
