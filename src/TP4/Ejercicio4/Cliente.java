package TP4.Ejercicio4;

import java.util.Random;

public class Cliente extends Thread {
    String texto;// texto es lo que imprime el cliente
    GestorImpresoras rc;
    int paginas;
    Random random = new Random();

    public Cliente(String texto, GestorImpresoras rc) {
        this.texto = texto;
        this.rc = rc;
        paginas = random.nextInt(10) + 1;
    }

    public String getTexto() {
        return texto;
    }

    public void run() {
        boolean exito = false;
        String nombre= Thread.currentThread().getName();
        try {
            // System.out.println(Thread.currentThread().getName());
            while (exito == false) {
                exito = rc.imprimir(texto,paginas,nombre);
            }
        } catch (InterruptedException e) {
        }
    }
}
