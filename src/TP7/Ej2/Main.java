package TP7.Ej2;

public class Main {
    public static void main(String[] args) {
        // Cantidad de computadoras y libros disponibles en la oficina
        int cantidadComputadoras = 3;
        int cantidadLibros = 3;

        // Crear la oficina compartida
        Oficina oficina = new Oficina(cantidadComputadoras, cantidadLibros);

        // Número de programadores a crear
        int cantidadProgramadores = 11;

        // Crear y arrancar los hilos de los programadores
        for (int i = 1; i <= cantidadProgramadores; i++) {
            Programador programador = new Programador(oficina, i);
            programador.start();
        }
    }
}
