package TP5.Ej5;

public class Pasajero extends Thread {
    Tren trenTuristico;

    public Pasajero(Tren trencito) {
        trenTuristico = trencito;
    }

    public void run() {
        try {
            trenTuristico.subir();
            System.out.println(Thread.currentThread().getName() + " se ha subido al tren");
            // espera a que el maquinista empiece el recorrido
            // trenTuristico.bajar();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
