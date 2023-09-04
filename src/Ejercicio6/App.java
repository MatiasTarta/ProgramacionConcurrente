package Ejercicio6;
public class App {
    public static void main(String[] args) throws Exception {
         
          int numCorredores=5;
        Corredor[] corredores = new Corredor[numCorredores]; // Arreglo de corredores

        corredores[4] = new Corredor("Leo Messi");
        corredores[1] = new Corredor("Judas");
        corredores[2] = new Corredor("Nico Cayo");
        corredores[3] = new Corredor("Davo Xeneixe");
        corredores[0] = new Corredor("Agusneta");

        // Crea hilos para cada corredor y comienza la carrera
        Thread[] hilosCorredores = new Thread[5]; // Arreglo de hilos
        hilosCorredores[0] = new Thread(corredores[0]);
        hilosCorredores[1] = new Thread(corredores[1]);
        hilosCorredores[2] = new Thread(corredores[2]);
        hilosCorredores[3] = new Thread(corredores[3]);
        hilosCorredores[4] = new Thread(corredores[4]);
        //Inicia los hilos
        for (int i = 0; i < numCorredores; i++) {
            hilosCorredores[i].start();
        }

        // Espera a que todos los corredores terminen la carrera
        for (int i = 0; i < numCorredores; i++) {
            try {
                hilosCorredores[i].join();
                if(31> corredores[i].getDistanciaRecorrida()){
                    System.out.println(corredores[i].getNombre()+" Gano");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
