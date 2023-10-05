package ActividadObligatoria;

public class Pasajero extends Thread{
    private String nombre;
    private Tren unTren;
    private Maquina boletera;

    public Pasajero(String nombre,Tren trencito,Maquina boleteria){
        this.nombre=nombre;
        unTren= trencito;
        boletera=boleteria;
    }

   
    public String getNombre(){
        return nombre;
    }

    public boolean comprarBoleto(){
        boolean exito= boletera.comprarTicket();
        return exito;
    }
    public void run(){
        boolean sePudoSubir=false;
        try {
            if(comprarBoleto()){
                while(sePudoSubir==false){
                 sePudoSubir=unTren.subir(nombre);
            }
            }else{
                System.out.println("SOLD OUT");
            }
            
        } catch (InterruptedException e) {
            //a
            e.printStackTrace();
        }
    }
}
