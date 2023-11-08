package TP7.Ejercicio1;

public class Persona extends Thread{
    char tipo;
    Sala museo;

    public Persona(String nombre,char tipo,Sala museito){
        super(nombre);
        this.tipo=tipo;
        museo=museito;
    }
    public void run(){
        
    }
}
