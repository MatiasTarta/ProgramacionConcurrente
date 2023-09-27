package TP4.Ejercicio4;

import java.util.Random;

public class Cliente extends Thread {
    String texto;// texto es lo que imprime el cliente
    GestorImpresoras rc;
    int paginas;
    Random random = new Random();
    String nombre;
    public Cliente(String texto, GestorImpresoras rc,String nombre) {
        this.texto = texto;
        this.rc = rc;
        paginas = random.nextInt(10) + 1;
        this.nombre=nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void run() {
        boolean exito = false;
        
        try {
            // System.out.println(Thread.currentThread().getName());
            while (exito == false) {
                exito = rc.imprimir(texto,paginas,nombre);
            }
        } catch (InterruptedException e) {
        }
    }
}
