package TP3.Ej4;

public class Area {
    int espacios, lugares;

    public Area(int total) {
        espacios = total;
        lugares = 0;
    }

    public synchronized String reservar(String nombre) {
        String comprobante = "";
        if (lugares <= espacios) {
            lugares++;
            comprobante = (nombre + " reservo el lugar Nº " + lugares);
        } else {
            comprobante = "No hay lugares disponibles por ahora";
        }
        return comprobante;
    }
}
