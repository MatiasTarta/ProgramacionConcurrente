package TP4.Ej4;

public class GestorImpresoras {
    private Impresora[] impresoras;

    // Constructor que inicializa el arreglo de impresoras
    public GestorImpresoras() {
        impresoras = new Impresora[8]; // Arreglo de 8 impresoras
        for (int i = 0; i < impresoras.length; i++) {
            impresoras[i] = new Impresora(i + 1); // Creamos cada impresora con un número identificador
        }
    }

}
