package TP3.Ej3;

public class Jaula {
    Plato platito;
    Hamaca hamaka;
    Rueda ruedita;

    public Jaula() {
        platito = new Plato();
        hamaka = new Hamaca();
        ruedita = new Rueda();
    }

    public void correr(String nombre) {
        ruedita.usarRueda(nombre);
    }

    public void dormir(String nombre) {
        hamaka.usarHamaca(nombre);
    }

    public void comer(String nombre) {
        platito.usarPlato(nombre);
    }
}
