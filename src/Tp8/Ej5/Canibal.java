package Tp8.Ej5;

public class Canibal extends Thread {
    Fogata tribu;
    int nombre;

    public Canibal(int n, Fogata f) {
        nombre = n;
        tribu = f;
    }

    public void run() {
        try {
            tribu.comer(nombre);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
