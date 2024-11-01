package TP7.Ej1;

public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();

        Medidor medidor = new Medidor(sala);
        medidor.start();

        for (int i = 1; i < 200; i++) {
            if (i % 5 == 0) {
                Persona persona = new Persona("El Jubilado " + i, 'J', sala);
                persona.start();
            } else {
                Persona persona = new Persona("La Persona " + i, 'N', sala);
                persona.start();
            }
        }
    }

}
