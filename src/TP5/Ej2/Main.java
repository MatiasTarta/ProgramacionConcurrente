package TP5.Ej2;

public class Main {
    public static void main(String[] args) {
        // Crear el comedero con 2 permisos
        Comedero comedero = new Comedero(2);

        // Crear los animales (6 perros y 9 gatos)
        Animal[] perros = new Animal[6];
        Animal[] gatos = new Animal[9];

        // Inicializar los perros
        for (int i = 0; i < 6; i++) {
            perros[i] = new Animal('P', comedero); // 1 porción para cada perro
        }

        // Inicializar los gatos
        for (int i = 0; i < 9; i++) {
            gatos[i] = new Animal('G', comedero); // 1 porción para cada gato
        }

        // Iniciar los hilos de los perros
        for (Animal perro : perros) {
            perro.start();
        }

        // Iniciar los hilos de los gatos
        for (Animal gato : gatos) {
            gato.start();
        }
    }
}
