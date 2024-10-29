package TP5.Ej6;

public class Avion extends Thread {
    private final Pista pista;
    private final char tipo; // 'A' para aterrizar, 'D' para despegar

    public Avion(Pista pista, char tipo) {
        this.pista = pista;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            if (tipo == 'A') {
                pista.aterrizar();
                System.out.println("Avion " + Thread.currentThread().getName() + " aterrizando...");
                Thread.sleep(1000); // Simula el tiempo de aterrizaje
                pista.entrarHangar();
                System.out.println("Avion " + Thread.currentThread().getName() + " entró al hangar.");

            } else if (tipo == 'D') {
                pista.intentarDespegue();
                System.out.println("Avion " + Thread.currentThread().getName() + " despegando...");
                Thread.sleep(1000); // Simula el tiempo de despegue
                pista.despegar();
                System.out.println("Avion " + Thread.currentThread().getName() + " ha despegado.");
            }
        } catch (InterruptedException e) {
            System.out.println("Avion " + Thread.currentThread().getName() + " fue derribado por el Pentagono.");
        }
    }
}
