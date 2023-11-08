package TP5.Ejericio7;

public class Visitante extends Thread {
    private int id;
    Mirador unMirador;

    public Visitante(int identificador,Mirador vista){
        id=identificador;
        unMirador=vista;
    }

    public void run(){
        try {
            unMirador.solicitarBajar();
            unMirador.usarTobogan();
            unMirador.salir();
        } catch (Exception e) {
        }
    }
}
