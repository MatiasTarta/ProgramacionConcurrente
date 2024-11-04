package Parciales.P2023;

import java.util.concurrent.Semaphore;

public class Planta {
    int cajaA, cajaV, almacen, max;
    private Semaphore semCajaA, semCajaV, semaforoEmpaquetador, semaforoAlmacen;

    public Planta() {
        cajaA = 0;// caja de aguas.Max 10
        cajaV = 0;// caja de vinos.Max 10
        almacen = 0;// espacio en el almacen.Max 100
        semCajaA = new Semaphore(1);
        semCajaV = new Semaphore(1);
        semaforoEmpaquetador = new Semaphore(0);
        semaforoAlmacen = new Semaphore(0);
        max = 5;
    }

    public void embotellar(char tipo) throws InterruptedException {
        if (tipo == 'A') {
            // le toca embotellar Aguas
            semCajaA.acquire();
            System.out.println("Se embotella una botella de Agua Saborizada");
            cajaA++;
            if (cajaA == max) {
                // si esta llena indica al empaquetador que la quite y coloque una nueva
                semaforoEmpaquetador.release();
            } else {
                semCajaA.release();// si todavia no se llena la caja sigue
            }
        } else if (tipo == 'V') {
            semCajaV.acquire();
            System.out.println("Se embotella una botella de Vino ");
            cajaV++;
            if (cajaV == max) {
                // caja llena
                semaforoEmpaquetador.release();
            } else {
                semCajaV.release();
            }
        }
    }

    public void empaquetar() throws InterruptedException {
        semaforoEmpaquetador.acquire();// hasta que una caja no se llene no arranca
        if (cajaA == max) {
            // verifica que caja este llena
            System.out.println("Se sella una caja de Aguas");
            almacen++;
            cajaA = 0;
            System.out.println("Se coloca una nueva caja de aguas");
            semCajaA.release();// ahora el empaquetador de aguas puede seguir todo chill
        } else if (cajaV == max) {
            // si entra esta caja esta llena
            System.out.println("Se sella una caja de Vinos");
            almacen++;
            cajaV = 0;
            System.out.println("Se coloca una nueva caja de vinos");
            semCajaV.release();
        }
        if (almacen == 100) {
            semaforoAlmacen.release();
        }
    }

    public void transportar() throws InterruptedException {
        semaforoAlmacen.acquire();
        System.out.println("Sale un camion del almacen cargado de escabiooo");
        almacen = 0;
    }

}
