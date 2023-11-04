package TP5.Ejercicio6;

public class Avion extends Thread {
    private int identificador;
    private char tipo;
    private Pista aeropuerto;

    public Avion(int identificador, char tipo,Pista pistita) {
        this.identificador = identificador;
        this.tipo = tipo;
       aeropuerto=pistita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public char getTipo() {
        return tipo;
    }
    public void run(){
        try {
            aeropuerto.usarPista(tipo,identificador);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
