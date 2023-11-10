package TP7.Ejercicio1;

public class Persona extends Thread{
    char tipo;
    Sala museo;

    public Persona(String nombre,Sala museito){
        super(nombre);
       
        museo=museito;
    }
    public void run(){
        try {
            String nombre= Thread.currentThread().getName();
            if(nombre.toLowerCase().contains("Jubilado")){
                museo.entrarSalaJubilado();
            }else{
                museo.entrarSala();
            }
            Thread.sleep(16000);
            museo.salirSala();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
