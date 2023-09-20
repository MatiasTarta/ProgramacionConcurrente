package TP4.Ejercicio3;

public class Hilo extends Thread {
    private char nombre;
    private int repeticiones;
    private RecursoCompartido recurso= new RecursoCompartido();

    public Hilo(char nombreProceso,int repeticiones){
        this.nombre=nombreProceso;
        this.repeticiones= repeticiones;
    }
    public void run(){
        try {
            recurso.imprimir(repeticiones, nombre);
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}