package Tp8.Ej1;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del Cuartel compartido
        Cuartel cuartel = new Cuartel();

        // Crear un arreglo de 100 soldados
        Soldado[] soldados = new Soldado[100];

        // Inicializar cada soldado con valores aleatorios para postre y gaseosa
        for (int i = 0; i < soldados.length; i++) {
            boolean postre = ThreadLocalRandom.current().nextBoolean();
            boolean gaseosa = ThreadLocalRandom.current().nextBoolean();
            soldados[i] = new Soldado(i, postre, gaseosa, cuartel);
        }

        // Iniciar todos los hilos de los soldados
        for (Soldado soldado : soldados) {
            soldado.start();
        }
    }
}
