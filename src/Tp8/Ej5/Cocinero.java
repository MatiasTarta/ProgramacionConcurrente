package Tp8.Ej5;

public class Cocinero extends Thread {
    Fogata tribu;

    public Cocinero(int n, Fogata f) {
        tribu = f;
    }

    public void run() {
        try {
            while (true) {
                tribu.cocinar();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
