package TP5.Ej2;

import java.util.concurrent.Semaphore;

public class SemaforoComedor extends Semaphore {
    int contadorInterno;
    int permisos;

    public SemaforoComedor(int permisos) {
        super(permisos);
        this.permisos = permisos;
        contadorInterno = permisos;
    }

    public void tomarPermiso() {
        contadorInterno--;
    }

    public int getContador() {
        return contadorInterno;
    }

    public void reiniciar() {
        // reinicia el contador
        contadorInterno = permisos;
    }
}
