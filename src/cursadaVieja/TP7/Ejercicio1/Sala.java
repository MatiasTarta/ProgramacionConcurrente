package TP7.Ejercicio1;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Sala {

    private int temperatura,limite,cantPersonas,jubiladosEnEspera;
    Random random;
    private Lock lock = new ReentrantLock();
    private Condition hayLugar = lock.newCondition();
    
    public Sala(){
        limite=20;
        temperatura=25;
        random= new Random();
        cantPersonas=0;
        jubiladosEnEspera=0;
    }

    
      public void cambiarTemperatura() {
        System.out.println("La temperatura es de: " + temperatura + " C°");
        // Genera un número aleatorio entre -5 y 5
        int cambio = random.nextInt(11) - 5;
        // Limita el cambio para que no baje de 17 ni suba de 40
        cambio = Math.min(5, Math.max(-5, cambio));
        // Calcula la nueva temperatura
        int nuevaTemperatura = temperatura + cambio;
        // Asegura que la temperatura esté en el rango [17, 40]
        temperatura = Math.min(40, Math.max(17, nuevaTemperatura));
        if(temperatura>=30 && cantPersonas<35){
            cambiarLimite(15);
            System.out.println("--------------------------------------------------------");
            System.out.println("Temperatura excesiva, limite de visitantes ajustado");
            System.out.println("--------------------------------------------------------");
        }else{
            cambiarLimite(20);
            System.out.println("Temperatura normal, limite de visitantes aumentado");
        }
    }
     

    public void cambiarLimite(int nuevoLimite){
        limite=nuevoLimite;
    }

    public void entrarSala(){
        lock.lock();
        try {
            while(cantPersonas>= limite || jubiladosEnEspera>0){
                //si no hay lugar o hay algun jubilado esperando, espera
                hayLugar.await();
            }
            System.out.println(Thread.currentThread().getName()+ " entro a la sala");
            cantPersonas++;
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void salirSala(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ " salio de la sala");
            cantPersonas--;
            hayLugar.signalAll();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void entrarSalaJubilado(){
        try {
            jubiladosEnEspera++;
            lock.lock();
            while (cantPersonas>=limite) {
                hayLugar.await();
            }
            System.out.println(Thread.currentThread().getName()+ " entro a la sala");
            cantPersonas++;
            jubiladosEnEspera--;

        } catch (Exception e) {
        }finally{
            lock.unlock();
        }
    }

}
