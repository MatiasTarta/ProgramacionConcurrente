package ActividadObligatoria;

public class Main {
    public static void main(String args[]){
        Tren diesel = new Tren();
        conTrolTren maquinista = new conTrolTren(diesel);
        int cantPasajeros=7;

        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        
        
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero("Pasajero "+(i+1), diesel);
        }
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i].start();
        }
        maquinista.start();
    }
}
