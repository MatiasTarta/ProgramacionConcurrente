package TP6.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        GestorTrafico gestor = new GestorTrafico(); // Instancia del gestor de tráfico

        // Creación de autos simulados con diferentes identificadores y tipos de dirección
        Auto auto1 = new Auto(1, gestor, 'N');
        Auto auto2 = new Auto(2, gestor, 'S');
        Auto auto3 = new Auto(3, gestor, 'N');
        Auto auto4 = new Auto(4, gestor, 'S');
        Auto auto5 = new Auto(5, gestor, 'N');
        Auto auto6 = new Auto(6, gestor, 'S');
        
        // Inicio de los hilos simulados de autos del 1 al 6
        auto1.start();
        auto2.start();
        auto3.start();
        auto4.start();
        auto5.start();
        auto6.start();

        // Creación adicional de autos para duplicar 'N' y triplicar 'S'
        for (int i = 7; i <= 12; i++) {
            Auto autoN = new Auto(i, gestor, 'N');
            autoN.start();
        }
        for (int i = 7; i <= 18; i++) {
            Auto autoS = new Auto(i, gestor, 'S');
            autoS.start();
        }
    }
}

