package Parcial.Ej1;

public class Transportador extends Thread {
    Planta planta;
    public Transportador(Planta plan){
        planta=plan;
    }

    public void run(){
        try {
            while (true) {
                planta.transportar();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
