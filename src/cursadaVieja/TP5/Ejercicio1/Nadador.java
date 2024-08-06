package TP5.Ejercicio1;

public class Nadador extends Thread {
    private GestorPileta gestor;
    private int num;
    public Nadador(GestorPileta gestor,int num){
        this.gestor=gestor;
        this.num=num;
    }

    public void run() {
        try {
            gestor.nadar(num);
        } catch (Exception ex) {

        }
    }
}
