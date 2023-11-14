package TP8.Ejercicio3;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola(){
        frente=null;
        fin=null;
    }
    public boolean poner(Object elem){
        Nodo aux= new Nodo(elem,null);
            if(esVacia()){
                frente= aux;
                fin=this.frente;
            }else{
                this.fin.setEnlace(aux);
                this.fin=aux;
            }
        return true;
    }
    public boolean esVacia(){
        return (this.fin == null & this.frente == null);
    }
    public void vaciar(){
        fin = null;
        while (!esVacia()) {
            frente = frente.getEnlace();
        }
    }
    public Object obtenerFrente(){
        Object retorna = null;
        if (!esVacia()) {
            retorna = this.frente.getElem();
        }
        return retorna;
    }
    public boolean sacar(){
        boolean exit=false;
        if (!esVacia()) { 
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
            exit = true;
        }
        return exit;
    }

    
    public Cola clone(){
        Cola colaClon= new Cola();
        if(!esVacia()){
            colaClon.frente= new Nodo(this.frente.getElem(),null);
            cloneAux(colaClon.frente,this.frente.getEnlace());
            colaClon.fin=new Nodo(fin.getElem(),null);
        }
        return colaClon;
    }
    private void cloneAux(Nodo nodoTemp, Nodo nodoEnlace){
        if(nodoEnlace != null){
            nodoTemp.setEnlace(new Nodo(nodoEnlace.getElem(),null));
            cloneAux(nodoTemp.getEnlace(),nodoEnlace.getEnlace());
        }
    }

    public String toString() {
        String cadena = " ";
        Nodo temp = this.frente;
        while (temp != null) {
            cadena = cadena + temp.getElem() ;
            temp = temp.getEnlace();
        }
        cadena = cadena + " ";
        return cadena;
    }
    //cambio
}
