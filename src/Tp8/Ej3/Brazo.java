package Tp8.Ej3;

public class Brazo extends Thread {
    Pasteleria pasti;

    public Brazo(Pasteleria p) {
        pasti = p;
    }

    public void run() {
        while (true) {
            try {
                pasti.retirarCaja();
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
