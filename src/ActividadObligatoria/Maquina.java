package ActividadObligatoria;

public class Maquina {
    private int total, vendidos;

    public Maquina(int tickets){
        total=tickets;
        vendidos=0;
    }
    public boolean seVendieronTodos(){
        return vendidos==total;
        //si se la cantidad de vendidos= total entonces se vendieron todos los tickets
    }
    public boolean comprarTicket(){
        boolean venta=false;
        if(vendidos<total){
            vendidos++;
            venta=true;
        }
        return venta;
    }
}
