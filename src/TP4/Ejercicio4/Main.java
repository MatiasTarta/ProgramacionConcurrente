package TP4.Ejercicio4;

public class Main {
    public static void main(String[] args) {
        GestorImpresoras dunderMifflin = new GestorImpresoras();
        Cliente marto = new Cliente("hola", dunderMifflin,"marto");
        Cliente membrillo = new Cliente("soy diego", dunderMifflin,"membrillo");
        Cliente davor = new Cliente("xdxd", dunderMifflin,"davor");
        Cliente jere = new Cliente("sale Aram", dunderMifflin,"jere");
        Cliente tomi = new Cliente("que onda perro", dunderMifflin,"tomi");
        Cliente hashinshi = new Cliente("hashinshison", dunderMifflin,"hashinshi");
        Cliente giuli = new Cliente("chuulo", dunderMifflin,"giuli");
        
        membrillo.start();
        marto.start();
        davor.start();
        jere.start();
        tomi.start();
        giuli.start();
        hashinshi.start();
    }
}
