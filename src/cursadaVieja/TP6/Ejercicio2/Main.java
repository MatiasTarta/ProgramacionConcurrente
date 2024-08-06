package TP6.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Sala biblioteca = new Sala(3);
        Estudiante[] estudiantes = new Estudiante[16];

        for(int i=0;i<estudiantes.length;i++){
            estudiantes[i]= new Estudiante("Estudiante "+i, biblioteca);
        }
        for(int j=0;j<estudiantes.length;j++){
            estudiantes[j].start();
        }
    }
}
