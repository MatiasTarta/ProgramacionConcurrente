package TP7.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Oficina theOficina = new Oficina(10, 6);
        Programador[] programamones = new Programador[21];
        for(int i=0;i<programamones.length;i++){
            programamones[i]= new Programador("Programamon "+i, theOficina);
        }
         for(int i=0;i<programamones.length;i++){
            programamones[i].start();
        }
    }
}
