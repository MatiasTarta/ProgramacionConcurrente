    package TP3.Ejercicio2;

    public class Main {
        public static void main(String[] args){
            Energia energia= new Energia();
            CriaturaOscura criaturaOscura = new CriaturaOscura(energia);
            Sanador sanador = new Sanador(energia);
            Thread h1= new Thread(criaturaOscura,"Voldemort");
            Thread h2= new Thread(sanador,"Pablo Kogan");
            h1.start();
            h2.start();
        }
    }
