package TP6.Ejercicio1;

public class Auto extends Thread {
    Puente puente;
    char tipo;
    public Auto(Puente gestor,char tipo,String nombre){
        super(nombre);
        this.puente=gestor;
        this.tipo=tipo;
    }

    public void run(){
        try {
            puente.entrar(tipo);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
