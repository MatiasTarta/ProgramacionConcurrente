package TP5.Ej5;

import java.util.concurrent.Semaphore;

public class Tren {
    int pasajeros, espacio;
    public Semaphore semaforoSubida, semaforoRecorrido, semaforoAsientos;

    public Tren(int e) {
        espacio = e;
        pasajeros = 0;
        semaforoSubida = new Semaphore(1);
        semaforoAsientos = new Semaphore(e);
    }

    public void subir() throws InterruptedException {
        semaforoAsientos.acquire();
        // si no hay asientos disponibles no intenta subirse y permite que el tren
        // parta, se queda esperando a que el recorrido de vuelta
        semaforoSubida.acquire();
        pasajeros++;// sube un pasajero
        semaforoSubida.release();
    }

    public void bajar() throws InterruptedException {
        semaforoAsientos.release(espacio);
        pasajeros = 0;
    }

    public boolean trenLleno() {
        return pasajeros >= espacio;
    }

    public void hacerRecorrido() throws InterruptedException {
        semaforoSubida.acquire();
        // se asegura que ningun pasajero se suba
    }

    public void detenerTren() {
        semaforoSubida.release();
        // termina el recorrido
    }

}
