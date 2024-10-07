package TP5.Ej1;

public class Nadador extends Thread {
    GestorPiscina pileta;

    public Nadador(GestorPiscina pileta) {
        this.pileta = pileta;
    }

    public void run() {
        try {
            pileta.entrar();
            System.out.println("Un Nadador entro a la pileta y esta nadando perrito");
            Thread.sleep(3500);
            pileta.escalera();
            System.out.println("El nadador se esta secando y se va");
            pileta.secarse();
            pileta.salir();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
