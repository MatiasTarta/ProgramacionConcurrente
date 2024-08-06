package TP7.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Sala museo= new Sala();
        Medidor termometro = new Medidor(museo);
        termometro.start();
        Persona[] visitantes = new Persona[90];

        for(int i=0;i<visitantes.length;i++){
            if(esPrimo(i)){
                visitantes[i]= new Persona("Jubilado "+i, museo);
            }else{
                visitantes[i]= new Persona("Visitante "+i, museo);
            }
        }
        for(int i=0;i<visitantes.length;i++){
            visitantes[i].start();
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }

        // Verifica si el número es divisible por algún otro número menor que él
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // El número es divisible, por lo tanto, no es primo
            }
        }

        return true; // Si no es divisible por ningún número menor que él, es primo
    }

}
