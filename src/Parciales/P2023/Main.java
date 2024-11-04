package Parciales.P2023;

public class Main {
    public static void main(String[] args) {

        Planta planti = new Planta();
        Empaquetador sergio = new Empaquetador(planti);
        Transportador eduardo = new Transportador(planti);
        Embotellador brazo1 = new Embotellador('A', planti);
        Embotellador brazo2 = new Embotellador('V', planti);
        sergio.start();
        eduardo.start();
        brazo1.start();
        brazo2.start();
    }
}
