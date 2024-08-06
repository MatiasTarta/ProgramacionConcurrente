package TP8.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Observatorio observatorio= new Observatorio(10);
        Persona[] visitantes= new Persona[100];

        for(int i=0;i<visitantes.length;i++){
            if(i==9 || i==18 ||i==36){
                visitantes[i]= new Persona("Mantenimiento "+i, observatorio);
            }else if(i==6 || i==48 ||i==99){
                visitantes[i]= new Persona("Investigador "+i, observatorio);
            }else{
                visitantes[i]= new Persona("Visistante "+i, observatorio);
            }

            if(i==11 || i==35 || i==40){
                 visitantes[i]= new Persona("Lisiado "+i, observatorio);
            }
        }

        for(int i=0;i<visitantes.length;i++){
             visitantes[i].start();
        }
    }
}
