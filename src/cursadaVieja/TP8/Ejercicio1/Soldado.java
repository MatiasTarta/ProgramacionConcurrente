package TP8.Ejercicio1;

public class Soldado extends Thread{
    Comedor comedor;
    boolean tienePostre,tieneGaseosa;
    public Soldado(String nombre,Comedor comida,boolean postre,boolean gaseosa){
        super(nombre);
        comedor=comida;
        tieneGaseosa=gaseosa;
        tienePostre=postre;
    }
    public void run(){
        try {
            comedor.servirseComida();
            if(tieneGaseosa){
                comedor.abrirGaseosa();
            }
            if(tienePostre){
                comedor.servirsePostre();
            }
            comedor.comer();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
