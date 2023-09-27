package TP4.Ejercicio4;

public class GestorImpresoras {
    private int cant = 3;
    private Impresora[] impresora = new Impresora[cant];
    public GestorImpresoras(){
        for(int i =0; i<cant ;i++){
            impresora[i] = new Impresora(1, true);
        }
    }
    public boolean imprimir(String texto) throws InterruptedException {
        int i = 0;
        boolean esperando = true;
        boolean exito=false;
        while (esperando && i<cant) {
            if (impresora[i].getDisponibilidad() == true) {
                // System.out.println(Thread.currentThread().getName());
                impresora[i].noDisponible();
                impresora[i].acquire();
                System.out.println("La impresora: " + i + " esta imprimiendo...");
                System.out.println(i+":"+texto);
                Thread.sleep(4000);
                System.out.println("La impresora: " + i + " termino");
                impresora[i].release();
                esperando = false;
                impresora[i].liberarDisponible();
                exito=true;
            }else{
                 i++;
            }
        }
        return exito;
    }
}
