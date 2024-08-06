package Parcial.Ej1;

public class Empaquetador extends Thread{
    Planta planta;
    public Empaquetador(Planta plan){
        planta=plan;
    }

    public void run(){
        try {
            while (true) {
                planta.empaquetar();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
