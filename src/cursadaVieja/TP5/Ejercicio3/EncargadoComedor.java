package TP5.Ejercicio3;

public class EncargadoComedor  extends Thread{
    Comedor comedero;

    public EncargadoComedor(Comedor comida){
        comedero= comida;
    }
    public void run(){
        System.out.println("Soy el engargado");
        while(true){
            
            comedero.cambiarTipo();
            
             try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //
                e.printStackTrace();
            }
           
        }
    }
}
