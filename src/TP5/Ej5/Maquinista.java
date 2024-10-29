package TP5.Ej5;

public class Maquinista extends Thread {
    Tren miTren;

    public Maquinista(Tren t) {
        miTren = t;
    }

    public void run() {
        while (true) {
            if (miTren.trenLleno()) {
                try {
                    miTren.hacerRecorrido();
                    System.out.println("El Tren da una vuelta");

                    int duracionTotalMs = 2000; // Duración total en milisegundos
                    int desplazamientos = 20; // Número de desplazamientos
                    int tiempoPorDesplazamiento = duracionTotalMs / desplazamientos;

                    for (int i = 0; i < desplazamientos; i++) {
                        // Limpia la consola
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        // Añade espacios para el desplazamiento del tren
                        String espaciado = " ".repeat(i);
                        System.out.println(espaciado + "_________\r\n" + //
                                espaciado + " |  _  |    __\r\n" + //
                                espaciado + " | | | |____\\/_\r\n" + //
                                espaciado + " | |_| |       \\\r\n" + //
                                espaciado + " | __  |  _  _  |\r\n" + //
                                espaciado + " |/  \\_|_/ \\/ \\/\r\n" + //
                                espaciado + "  \\__/   \\_/\\_/");

                        // Pausa para el efecto de animación
                        Thread.sleep(tiempoPorDesplazamiento);
                    }
                    miTren.detenerTren();
                    System.out.println("todos abajo");
                    miTren.bajar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
