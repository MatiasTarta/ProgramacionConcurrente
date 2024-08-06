package TP6.Ejercicio1;

public class Puente {
    boolean direccionNorte;
    private int contadorDireccion;


    public Puente(){
        direccionNorte=false;
        contadorDireccion=0;
    }

    public void entrar(char tipo){
        if(tipo=='N'){
            try {
                entrarNorte();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(tipo=='S'){
            try {
                entrarSur();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void entrarNorte()throws InterruptedException{
        while (!(direccionNorte)&& contadorDireccion==2) {
            wait();
        }
        System.out.println(Thread.currentThread().getName()+ " esta entrando por el norte");
        Thread.sleep(2000);
        contadorDireccion++;
        salirSur();
    }

    public void entrarSur()throws InterruptedException{
        while (direccionNorte && contadorDireccion==3) {
            wait();
        }
        System.out.println(Thread.currentThread().getName()+ " esta entrando por el sur");
        Thread.sleep(2000);
        contadorDireccion++;
        salirNorte();
    }

    public void salirNorte(){
        System.out.println(Thread.currentThread().getName()+ " esta saliendo por el norte");
        
        if(contadorDireccion==3){
            direccionNorte= !direccionNorte;
            contadorDireccion=0;
        }
        this.notify();
    }

    public void salirSur(){
        System.out.println(Thread.currentThread().getName()+ " esta saliendo por el sur");
        if(contadorDireccion==2){
            direccionNorte= !direccionNorte;
            contadorDireccion=0;
        }
        this.notify();
    }
}
