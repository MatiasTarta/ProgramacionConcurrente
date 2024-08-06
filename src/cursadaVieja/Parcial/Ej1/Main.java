package Parcial.Ej1;

public class Main {
    public static void main(String[] args) {
        Planta p= new Planta();
        Empaquetador e= new Empaquetador(p);
        Transportador t= new Transportador(p);
        Embotellador[] embotelladores= new Embotellador[16];
        for(int i=0;i<embotelladores.length;i++){
            if(i%2==0){
                embotelladores[i]= new Embotellador('A', p);
            }else{
                embotelladores[i]= new Embotellador('V', p);
            }
        }
        e.start();
        t.start();
         for(int i=0;i<embotelladores.length;i++){
            embotelladores[i].start();
         }

    }
}