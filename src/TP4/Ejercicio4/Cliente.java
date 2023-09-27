package TP4.Ejercicio4;

public class Cliente extends Thread{
    String texto;// texto es lo que imprime el cliente
    GestorImpresoras rc;
    public Cliente(String texto,GestorImpresoras rc){
        this.texto=texto;
        this.rc = rc;
    }
    public String getTexto(){
        return texto;
    }
    public void run(){
        boolean exito=false;
            try {
                //System.out.println(Thread.currentThread().getName());
              while(exito==false){
                 exito= rc.imprimir(texto);
              }
            }
              catch (InterruptedException e) {
              }
    }
}
