package Tp8.Ej3;

public class Main {
    public static void main(String[] args) {

        Pasteleria emilia = new Pasteleria();
        Empaquetador empaquetador1, empaquetador2;
        Brazo brazo = new Brazo(emilia);
        empaquetador1 = new Empaquetador(emilia);
        empaquetador2 = new Empaquetador(emilia);
        empaquetador1.start();
        empaquetador2.start();
        brazo.start();
    }
}
