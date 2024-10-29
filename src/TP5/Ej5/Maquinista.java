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
                    Thread.sleep(5000);
                    System.out.println("El Tren da una vuelta ");
                    System.out.println("_________\r\n" + //
                            " |  _  |    __\r\n" + //
                            " | | | |____\\/_\r\n" + //
                            " | |_| |       \\\r\n" + //
                            " | __  |  _  _  |\r\n" + //
                            " |/  \\_|_/ \\/ \\/\r\n" + //
                            "  \\__/   \\_/\\_/");
                    miTren.detenerTren();
                    System.out.println("todos abajo");
                    miTren.bajar();
                } catch (Exception e) {
                    //
                }
            }
        }
    }
}
