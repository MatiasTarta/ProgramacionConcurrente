package TP5.Ejercicio1;

public class GestorPileta {
    Pileta pileta;

    public GestorPileta(Pileta pileta){
        this.pileta=pileta;
    }
    public void nadar(int num) {
        try {
            pileta.dejarEntrar(num);
        } catch (Exception ex) {

        }
    }
}
