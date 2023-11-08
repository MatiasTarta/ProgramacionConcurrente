package TP6.Ejercicio2;

public class Estudiante extends Thread{
    int id;
    Sala biblioteca;
    public Estudiante(int identificador,Sala salita){
        id=identificador;
        biblioteca=salita;
    }

    public void run(){
        try {
            biblioteca.entrar(id);
            biblioteca.salir(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
