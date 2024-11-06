package Parciales.Parcial2.Ej1;
public class Main {
    public static void main(String[] args) {
        Fabrica francoFabris=new Fabrica(5,2 ,1);
        Empleado equipo1 = new Empleado(francoFabris,1);
        Empleado equiEmpleado2= new Empleado(francoFabris,2 );
        Empleado equipo3= new Empleado(francoFabris,3 );
        Empleado equipo4= new Empleado(francoFabris, 4);
        equipo1.start();
        equiEmpleado2.start();
        equipo3.start();
        equipo4.start();
    }
}
