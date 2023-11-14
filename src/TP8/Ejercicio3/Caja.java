package TP8.Ejercicio3;

public class Caja {
    private int peso,pesoMax;

    public Caja(int pesoLimite){
        pesoMax=pesoLimite;
        peso=0;
    }

    public void aumentarPeso(int kg){
        this.peso=peso+kg;
    }
    public int getPeso(){return peso;}
    public int getLimite(){return pesoMax;}
}
