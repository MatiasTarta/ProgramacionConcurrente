package TP4.Ejercicio4;

public class GestorImpresoras {
    private int cant = 3;
    private Impresora[] impresora = new Impresora[cant];
    public GestorImpresoras(){
        for(int i =0; i<cant ;i++){
            impresora[i] = new Impresora(1, true);
        }
    }
    public boolean imprimir(String texto,int paginas,String nombre) throws InterruptedException {
        //variable paginas para simular tiempos de impresion distintos en cada hilko
        int i = 0;
        boolean esperando = true;
        boolean exito=false;
        while (esperando && i<cant) {
            if (impresora[i].getDisponibilidad() == true) {
                // System.out.println(Thread.currentThread().getName());
                impresora[i].noDisponible();
                impresora[i].acquire();
                System.out.println(nombre+" esta imprimiendo en la impresora: " + i + "...");
                System.out.println(i+":"+texto);
                Thread.sleep(1000*paginas);//simula tiempo de impresion
                System.out.println(nombre+ " termino de imprimir en la impresora "+i);
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
