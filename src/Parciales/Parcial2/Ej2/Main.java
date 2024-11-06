package Parciales.Parcial2.Ej2;

public class Main {
    public static void main(String[] args) {
        // Configuración del parque con capacidad máxima de 10 y cupo de escuelas de 3
        int capacidadMaxima = 30;
        int cupoEscuela = 15;
        Parque parque = new Parque(capacidadMaxima, cupoEscuela);

        // Crear y lanzar hilos de visitantes, residentes y escuelas
        for (int i = 0; i < 5; i++) {
            new VisitanteNormal(parque).start();
        }

        for (int i = 0; i < 3; i++) {
            new Residente(parque).start();
        }

        for (int i = 0; i < 2; i++) {
            new Escuela(parque).start();
        }
    }
}

