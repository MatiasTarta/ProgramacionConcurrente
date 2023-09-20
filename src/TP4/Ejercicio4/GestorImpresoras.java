package TP4.Ejercicio4;

public class GestorImpresoras {
    private Impresora impresora1;
    private Impresora impresora2;
    private Impresora impresora3;
    private Impresora impresora4;
    private Impresora[] impresoras;


    public GestorImpresoras(){
        impresora1= new Impresora();
        impresora2= new Impresora();
        impresora3= new Impresora();
        impresora4= new Impresora();
        impresoras = new Impresora[4];

    }
    public void imprimir(String impresion){
        boolean libre=false;
        int i=0;
        Impresora  actual;
        do{
            actual= impresoras[i];
            libre= actual.getEstado();

        }while(libre==false);
        if(libre){
            
        }else{
            System.out.println("NO hay impresoras disponibles");
        }
    }
}
