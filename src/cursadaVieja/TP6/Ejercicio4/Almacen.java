package TP6.Ejercicio4;

public class Almacen {
    
    private int producto,capacidad;

    public Almacen(int maximo){
        producto=0;
        capacidad=maximo;
    }


    public synchronized void colocarProducto() throws InterruptedException{
        
        producto++;
        System.out.println("El productor pone un producto en el Almacen.Ahora Hay "+producto);
        this.notifyAll();
    }

    public synchronized void consumir()throws InterruptedException{
       while ((producto<=0)) {
        wait();
       }
        producto--;
        System.out.println(Thread.currentThread().getName()+" retira un producto, ahora hay "+producto);
    }
}
