package ActividadObligatoria;

public class conTrolTren extends Thread{
    private Tren unTren;
    public conTrolTren(Tren trencito){
        unTren=trencito;
    }
     public void run(){
        while(true){
            try{
                unTren.recorrer();
            }catch(InterruptedException ex) {
            }
        }
     }
}
