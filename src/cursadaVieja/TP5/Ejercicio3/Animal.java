package TP5.Ejercicio3;

public class Animal extends Thread{
    char tipo;
    Comedor comida;

    public Animal(char tipo,Comedor comida){
        this.tipo=tipo;
        this.comida=comida;
    }
    public void run() {
        try{
            comida.ingresar(tipo);
        }catch(InterruptedException ex){
            System.out.println("XD");
        }
    }
}