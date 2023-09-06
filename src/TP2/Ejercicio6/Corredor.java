package TP2.Ejercicio6;
import java.util.Random;

class Corredor implements Runnable {
    private String nombre;
    private int distanciaRecorrida;

    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }
    public String getNombre(){
        return nombre;
    }
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }


    @Override
    public void run() {
        Random rand = new Random();
        int totalPasos = 30;

        for (int i = 0; i < totalPasos; i++) {
            int avance = rand.nextInt(10) + 1; // Avance aleatorio entre 1 y 10 metros
            distanciaRecorrida += avance;

            System.out.println(
                    nombre + " ha avanzado " + avance + " pasos.");
            try {
                Thread.sleep(100); // Simula el tiempo de descanso entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(nombre + " ha terminado la carrera!");
    }
}
