package TP6.Ej7;

public class Ferry {
    int plazas, asientos, totalPlazas, totalAsientos;
    // plazas son las plazas de estacionamiento para autos y asientos para personas
    boolean salida = false;// variable para controlar recorrido del ferry y evitar que desciendan

    public Ferry(int p, int a) {
        plazas = 0;
        asientos = 0;
        totalAsientos = a;
        totalPlazas = p;
    }

    public synchronized void sentarse() throws InterruptedException {
        while (asientos == totalAsientos) {
            this.wait();
        }
        asientos++;
        System.out.println("El pasajero " + Thread.currentThread().getName() + " ocupo un asiento");
        System.out.println("Quedan " + (totalAsientos - asientos) + " espacios");
        this.notifyAll();// hace notify all para avisar al control ferry y que este chequee si empieza el
                         // recorrido o no
    }

    public synchronized void estacionar() throws InterruptedException {
        while (plazas == totalPlazas) {
            this.wait();
        }
        plazas++;
        System.out.println("El automovil " + Thread.currentThread().getName() + " ocupo una plaza");
        System.out.println("Quedan " + (totalPlazas - plazas) + " plazas disponibles");
        this.notifyAll();
    }

    public boolean lleno() {
        return (plazas == totalPlazas && asientos == totalAsientos);
    }

    public synchronized void hacerRecorrido() throws InterruptedException {
        while (!this.lleno()) {
            this.wait();
        }
        salida = false;// inhabilita la salida de vehiculos
        System.out.println("El ferry inicia su recorrido");
    }

    public synchronized void bajar() throws InterruptedException {
        while (!salida) {
            this.wait();
        }
        System.out.println("El recorrido termino y el pasajero puede bajar");
        asientos--;
        this.notifyAll();
    }

    public synchronized void desembarcar() throws InterruptedException {
        while ((!salida)) {
            this.wait();
        }
        System.out.println("El reccorido termino y el auto desembarca");
        plazas--;
        this.notifyAll();
    }

    public synchronized void finalizarRecorrido() {
        System.out.println("ALTO el recorrido termina");
        salida = true;
        notifyAll();
    }

}
