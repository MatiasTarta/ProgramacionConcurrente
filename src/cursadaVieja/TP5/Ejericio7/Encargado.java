package TP5.Ejericio7;

public class Encargado extends Thread{
    Mirador unMirador;

    public Encargado(Mirador vista){
        unMirador=vista;
    }

    public void run(){
        while(true){
            try {
                unMirador.hacerBajar();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
