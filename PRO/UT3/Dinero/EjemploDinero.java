package PRO.UT3.Dinero;

public class EjemploDinero {
    public static void main(String[] args){
        Dinero porLavar = new Dinero(49);
        Dinero demasiado = new Dinero(101);
        demasiado.getDinero();
        System.out.println("Vamos a lav... quiero decir \"contar\" estos " + porLavar.getDinero() + " euros que definitivamente conseguí de forma honesta.");
        porLavar.printDescomposicionMonedas();
    }
}