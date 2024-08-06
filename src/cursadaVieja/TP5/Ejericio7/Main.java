package TP5.Ejericio7;

public class Main {
    public static void main(String[] args){
        Mirador costaBrava = new Mirador(10);
        Encargado donEncargado = new Encargado(costaBrava);
        Visitante[] visitantes = new Visitante[15];

        for(int i=0;i<visitantes.length;i++){
            visitantes[i]= new Visitante(i, costaBrava);
        }
        for(int i=0;i<visitantes.length;i++){
            visitantes[i].start();
        }
        donEncargado.start();
    }
}
