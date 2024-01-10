package PRO.UT5.FrecuenciaDado;
import  java.util.Random;

public class Dado  {
    private int cara;
    private Random generador;

    public Dado(){
        generador = new Random();
        cara = 1;
    }

    public int getCara(){return cara;}

    public int tirarDado(){
        cara = generador.nextInt(6) + 1;
        return cara;
        //System.out.println("Salío el "+cara);
    }
}