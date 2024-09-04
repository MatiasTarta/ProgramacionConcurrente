package TP3.Ej2;

public class Entidad extends Thread {
    private int vida;
    private Energia energia;

    public Entidad(int vida, Energia en) {
        this.vida = vida;
        energia = en;
    }

    public void accion() {
        energia.atacar(vida);
    }

    public void run() {
        while (energia.valorMana() >= 10) {
            try {
                accion();
                System.out.println(Thread.currentThread().getName() + " ataco la fuente de mana. Energia actual: "
                        + energia.valorMana());
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
