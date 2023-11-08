package TP5.Ejercicio6;

public class TorreControl {
    Pista pista;
    public TorreControl(Pista pista){
        this.pista=pista;
    }

    public void usarPista(char tipoAvion,int avion) throws InterruptedException{
        if(tipoAvion=='A'){
            if(pista.contadorAterrizajes()<3){
                pista.aterrizar(avion);
            }else{
                if(pista.contadorDespegues()>0){
                    System.out.println("CARLITOS");
                    //si quedan despegues por hacerse
                       pista.priorizarDespegue(avion);
                }
            }
        } else if(tipoAvion=='D'){
            //el avion despega
        }
    }
}
