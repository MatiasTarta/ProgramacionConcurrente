package TP6.Ej7;

public class Main {
    public static void main(String[] args) {
        Ferry ferry = new Ferry(5, 10); // Ferry con 5 plazas para autos y 10 asientos para personas

        // Crear y arrancar hilos de automóviles
        for (int i = 1; i <= 20; i++) {
            new Automovil(ferry, "Automovil " + i).start();
        }

        // Crear y arrancar hilos de pasajeros
        for (int i = 1; i <= 40; i++) {
            new Pasajero(ferry, "Pasajero" + i).start();
        }

        // Crear y arrancar el hilo de ControlFerry
        ControlFerry controlFerry = new ControlFerry(ferry);
        controlFerry.start();
    }
}
