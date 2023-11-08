package TP6.Ejercicio1;

public class Auto extends Thread {
    GestorTrafico gestor;
    private int id;
    char tipo;
    public Auto(int id,GestorTrafico gestor,char tipo){
        this.gestor=gestor;
        this.id=id;
        this.tipo=tipo;
    }

    public void run(){
        try {
            gestor.entrar(tipo,id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
