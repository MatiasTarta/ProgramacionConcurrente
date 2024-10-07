package TP5.Ej1;

public class Main {
    public static void main(String[] args) {
        GestorPiscina pileta = new GestorPiscina(15);

        // Crear un arreglo de 20 Nadadores
        Nadador[] nadadores = new Nadador[20];

        // Inicializar el arreglo y comenzar los threads
        for (int i = 0; i < nadadores.length; i++) {
            nadadores[i] = new Nadador(pileta);
            nadadores[i].start(); // Iniciar cada thread
        }
    }
}
