package TP4.Ejercicio7;

public class Mozo extends Thread {

    private Confiteria conf;

    public Mozo(Confiteria unaConf) {
        conf = unaConf;
    }

    public void run() {
        while (true) {
            try {
                conf.hobby();
            } catch (InterruptedException ex) {
               // Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Haciendo el pollito");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Mozo.class.getName()).log(Level.SEVERE, null, ex);
            }
            conf.entregaComida();
        }
    }
}
