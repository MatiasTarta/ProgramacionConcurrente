package TP5.Ej6;

public class Avion extends Thread {
    private char tipo;
    private Pista torre;

    public Avion(String nombre, char tipo, Pista torre) {
        super(nombre);
        this.tipo = tipo;
        this.torre = torre;
    }

    public char getTipo() {
        return tipo;
    }

    public void run() {
        try {
            torre.usarPista(tipo);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}