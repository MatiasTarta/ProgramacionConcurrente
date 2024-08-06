package ActividadObligatoria;

public class conTrolTren extends Thread{
    private Tren unTren;
    private Maquina boletera;
    public conTrolTren(Tren trencito,Maquina boleteria){
        unTren=trencito;
        boletera=boleteria;
    }
     public void run(){
        while(boletera.seVendieronTodos()){
            try{
                unTren.recorrer();
            }catch(InterruptedException ex) {
            }
        }
     }
}
