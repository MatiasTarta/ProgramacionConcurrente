package TP6.Ejercicio7;

public class Entidad extends Thread {
    Ferry chuku;
    char tipo;
    public Entidad(String nombre,Ferry barquito,char tipo){
        super(nombre);
        chuku=barquito;
        this.tipo=tipo;
    }

    public void run(){
        try {
            chuku.abordar(tipo);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
