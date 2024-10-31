package TP6.Ej2;

public class Mesas {
    int mesas;
    int mesasOcupadas;

    public Mesas(int m) {
        mesas = m;
        mesasOcupadas = 0;
    }

    public synchronized void estudiar(int nombre) throws InterruptedException {
        while (mesasOcupadas == mesas) {
            this.wait();
            // si la cantidad de mesas ocupadas equivale a las mesas totales, no hay lugar y
            // el hilo espera
        }
        System.out.println("Estudiante Nº " + nombre + " se sento a Estudiar");
        mesasOcupadas++;
        // aca ya salio del while entonces se libero una mesa
    }

    public synchronized void salir(int nombre) {
        System.out.println("Estudiante Nº " + nombre + " se fue");
        mesasOcupadas--;
        this.notify();// avisa que se libero un lugars
    }

}
