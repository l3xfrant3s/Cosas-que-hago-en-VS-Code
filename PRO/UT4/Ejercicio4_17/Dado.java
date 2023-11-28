package PRO.UT4.Ejercicio4_17;
import  java.util.Random;

public class Dado  {
    private int cara; //ultima == cara del ejercicio
    private Random generador;

    public Dado(){
        generador = new Random();
        cara = 1;
    }

    public int getCara(){return cara;}

    public void tirarDado(){
        cara = generador.nextInt(6) + 1;
        System.out.println("Salío el "+cara);
    }
}