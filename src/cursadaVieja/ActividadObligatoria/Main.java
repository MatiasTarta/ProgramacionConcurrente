package ActividadObligatoria;

public class Main {
    public static void main(String args[]){
        Tren diesel = new Tren();
        Maquina boletera = new Maquina(5);
        conTrolTren maquinista = new conTrolTren(diesel,boletera);
        int cantPasajeros=9;
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        
        
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero("Pasajero "+(i+1), diesel,boletera);
        }
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i].start();
        }
        maquinista.start();
    }
}
