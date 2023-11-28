package PRO.UT4.Ejercicio4_17;
import  java.util.Random;

public class Dado2  {
    private int ultima; //ultima == cara del ejercicio
    private final int caras;
    private Random generador;

    public Dado2(int cuantasCaras){
        generador = new Random();
        ultima = 1;
        caras = (cuantasCaras>1?cuantasCaras:6);
    }

    public int getCara(){return ultima;}

    public void tirarDado(){
        ultima = generador.nextInt(caras) + 1;
    }

    public int tirarDadoYGetCara(){
        ultima = generador.nextInt(caras) + 1;
        return ultima;
    }
}