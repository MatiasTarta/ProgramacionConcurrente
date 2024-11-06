package Parciales.Parcial2.Ej1;
    public class Empleado extends Thread {
    private final Fabrica fabrica;
    private final int equipo; // 1: produce ruedas, 2: produce puertas, 3: produce carroceria, 4: ensamblar

    public Empleado(Fabrica fabrica, int equipo) {
        this.fabrica = fabrica;
        this.equipo = equipo;
    }

    @Override
    public void run() {
        try {
            switch (equipo) {
                case 1:
                    while (true) {
                        fabrica.producirRuedas();
                        Thread.sleep(500); // Simular tiempo de producción
                    }
                case 2:
                    while (true) {
                        fabrica.producirPuertas();
                        Thread.sleep(500);
                    }
                case 3:
                    while (true) {
                        fabrica.producirCarroceria();
                        Thread.sleep(500);
                    }
                case 4:
                    while (true) {
                        fabrica.ensamblar();
                        Thread.sleep(500); // Ensamblar toma más tiempo
                    }
                default:
                    System.out.println("Equipo no reconocido");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Empleado interrumpido: " + e.getMessage());
        }
    }
}

