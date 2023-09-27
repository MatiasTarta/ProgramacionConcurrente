package TP4.Ejercicio4;

public class Main {
    public static void main(String[] args) {
        GestorImpresoras dunderMifflin = new GestorImpresoras();
        Cliente marto = new Cliente("hola", dunderMifflin);
        Cliente membrillo = new Cliente("soy diego", dunderMifflin);
        Cliente davor = new Cliente("xdxd", dunderMifflin);
        Cliente jere = new Cliente("sale Aram", dunderMifflin);
        Cliente tomi = new Cliente("que onda perro", dunderMifflin);
        Cliente hashinshi = new Cliente("hashinshison", dunderMifflin);
        Cliente giuli = new Cliente("chuulo", dunderMifflin);
        
        membrillo.start();
        marto.start();
        davor.start();
        jere.start();
        tomi.start();
        giuli.start();
        hashinshi.start();
    }
}
