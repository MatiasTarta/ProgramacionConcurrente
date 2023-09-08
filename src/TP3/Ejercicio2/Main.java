    package TP3.Ejercicio2;

    public class Main {
        public static void main(String[] args){
            Energia vida= new Energia();
            Entidad magoOscuro= new Entidad(-3,vida);
            Entidad curandero = new Entidad(3, vida);

            Thread h1= new Thread(magoOscuro,"Voldemort");
            Thread h2= new Thread(curandero, "Dombuldor");
            h1.start();
            h2.start();
        }
    }
