package TP5.Ejercicio3;

public class Main {
    public static void main(String[] args){
        
        Comedor comedor  = new Comedor(5, 6);

        EncargadoComedor eduardo = new EncargadoComedor(comedor);
        Animal[] perros = new Animal[21];
        for(int i=0;i< perros.length;i++){
            perros[i]= new Animal('P', comedor);
        }

        Animal[] gatos = new Animal[4];
        for(int i=0;i<gatos.length;i++){
            gatos[i]= new Animal('G', comedor);
        }

        eduardo.start();
        for(int i=0;i< perros.length;i++){
            perros[i].start();
        }
        for(int i=0;i< gatos.length;i++){
            gatos[i].start();
        }

    }
}
