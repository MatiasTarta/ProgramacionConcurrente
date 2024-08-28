package TP3.Ej2;

public class Main {
    public static void main(String[] args) {
        Energia mana = new Energia(10);
        Entidad sanador = new Entidad(3, mana);
        Entidad magoOscuro = new Entidad(-3, mana);

        sanador.start();
        magoOscuro.start();
    }
}
