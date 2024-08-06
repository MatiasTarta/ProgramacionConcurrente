package cursadaVieja.BarberoDormilon;

public class Main {
    public static void main(String[] args){
        Asiento sillon = new Asiento();
        Barbero joni = new Barbero(sillon);
        Cliente[] bros = new Cliente[4];
        for (int i = 0; i < bros.length; i++) {
            bros[i] = new Cliente(sillon, i);
        }
        
        for (int i = 0; i < bros.length; i++) {
            bros[i].start();
        }
        joni.start();
    }
}
