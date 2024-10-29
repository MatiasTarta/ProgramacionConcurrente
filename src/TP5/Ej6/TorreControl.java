package TP5.Ej6;

public class TorreControl extends Thread {
    Pista pistaAterrizaje;

    public TorreControl(Pista p) {
        pistaAterrizaje = p;
    }

    public void run() {
        while (true) {
            if (pistaAterrizaje.forzarDespegue()) {

                try {
                    System.out.println("pepe");
                    pistaAterrizaje.detenerAterrizajes();
                    System.out.println("Se prioriza un despegue");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                pistaAterrizaje.priorizarDespegue();
                // pistaAterrizaje.retomar();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
