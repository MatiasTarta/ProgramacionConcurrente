package Tp8.Ej4;

public class Main {
    public static void main(String[] args) {
        // Crear el recurso compartido Centro de hemoterapia
        Centro centro = new Centro();

        // Crear y arrancar múltiples donantes
        for (int i = 1; i <= 20; i++) { // Simulamos 20 donantes
            Donante donante = new Donante(i, centro);
            donante.start();
        }
    }
}
