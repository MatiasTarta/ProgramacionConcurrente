package TP6.Ejercicio2;

import java.util.Random;

public class Estudiante extends Thread {
    
    private Sala sala;
    
    public Estudiante(String nombre, Sala sala) {
        super(nombre);
        this.sala = sala;
    }
    
    public void run() {
        Random random = new Random();
        try {
            sala.entrar();
            Thread.sleep(random.nextInt(1001) + 1000);
            sala.salir();
        } catch(Exception ex) {
            
        }
    }
    
}
