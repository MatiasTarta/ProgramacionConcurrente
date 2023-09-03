class Corredor implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    public Corredor(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " ha recorrido " + (i * 10) + " metros.");
            distanciaRecorrida = i * 10;
            try {
                Thread.sleep(100); // Simula el tiempo que toma avanzar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha terminado la carrera!");
    }
}
