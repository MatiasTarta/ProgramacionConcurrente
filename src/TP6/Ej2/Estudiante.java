package TP6.Ej2;

public class Estudiante extends Thread {
    Mesas biblio;
    int nombre;

    public Estudiante(Mesas m, int i) {
        biblio = m;
        nombre = i + 1;
    }

    public void run() {
        try {
            biblio.estudiar(nombre);
            Thread.sleep(2500);
            biblio.salir(nombre);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
