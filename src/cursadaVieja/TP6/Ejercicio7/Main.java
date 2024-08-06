package TP6.Ejercicio7;

public class Main {
    public static void main(String[] args) {
        Ferry barco = new Ferry(7, 11);
        MaquinistaFerry doc = new MaquinistaFerry(barco);
        Entidad[] ocupantes= new Entidad[48];

        for(int i=0;i<48/2;i++){
            ocupantes[i]= new Entidad("Auto "+i, barco, 'A');
        }
        for(int j=48/2;j<ocupantes.length;j++){
            ocupantes[j]= new Entidad("Persona "+j, barco, 'P');
        }
        doc.start();
        for(int k=0;k<ocupantes.length;k++){
            ocupantes[k].start();
        }
    }
}