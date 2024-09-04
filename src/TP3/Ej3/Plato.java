package TP3.Ej3;

public class Plato {
    public synchronized void usarPlato(String nombre) {
        System.out.println("El Hamster: " + nombre + " esta comiendo");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("El Hamster: " + nombre + " termino de comer");
    }
}
