package ActividadObligatoria;

public class Pasajero extends Thread{
    private String nombre;
    private Tren unTren;

    public Pasajero(String nombre,Tren trencito){
        this.nombre=nombre;
        unTren= trencito;
    }

   
    public String getNombre(){
        return nombre;
    }
    public void run(){
        boolean sePudoSubir=false;
        try {
            
            while(sePudoSubir==false){
                 sePudoSubir=unTren.subir(nombre);
            }
        } catch (InterruptedException e) {
            //a
            e.printStackTrace();
        }
    }
}
