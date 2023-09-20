package TP4.Ejercicio4;



public class Impresora {
    boolean disponible,ocupada;

    public Impresora(){
        disponible=true;
        ocupada= !disponible;
    }
    public boolean getEstado(){
        return disponible;
    }
}
