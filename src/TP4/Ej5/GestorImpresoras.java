package TP4.Ej5;

public class GestorImpresoras {
    private Impresora[] impresoras;

    // Logica del gestor: El cliente recorre las impresoras disponibles en circulo
    // hasta que logra imprimir. cada impresoras tiene un semaforo que controla si
    // esta ocupada o no ademas de una bandera booleana
    public GestorImpresoras() {
        impresoras = new Impresora[5]; // Arreglo de 8 impresoras
        for (int i = 0; i < impresoras.length; i++) {
            impresoras[i] = new Impresora(i + 1); // Creamos cada impresora con un número identificador
        }
    }

    public void imprimir() {
        int i = 0;
        boolean libre = false;// inicializo en false para entrar al while
        while (libre == false) {
            // si la impresora no esta libre checkea las impresoras que hay y las recorre
            // hasta que imprime
            libre = impresoras[i].libre();
            if (libre == false) {
                i++;// si no la puede usar busca la siguiente
            } else {
                try {
                    impresoras[i].usar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == impresoras.length) {
                i = 0;// si ya busco todas las impresoras empieza desde la 1ra otra vez
            }
        }
    }

}
