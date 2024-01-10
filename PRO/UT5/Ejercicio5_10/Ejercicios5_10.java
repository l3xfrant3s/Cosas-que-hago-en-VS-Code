package PRO.UT5.Ejercicio5_10;

import java.util.Random;

import PRO.MickeyHerramientas;

public class Ejercicios5_10 {
    static final int MAX = 10;
    static Random generador = new Random();
    public static void main(String[] args) {
        int[] paresAleatorios = generarArray();
        MickeyHerramientas.imprimirArray(paresAleatorios);//Imprime "{a,b,c...}"
    }

    public static int[] generarArray(){
        int[] numerosPares = new int[MAX];
        int cuantosPares = 0;
        int aleatorio = 0;
        while(cuantosPares < MAX){
            aleatorio = generador.nextInt(50)+1;
            if(aleatorio%2==0){
                numerosPares[cuantosPares] = aleatorio;
                cuantosPares++;
            }
        }
        return numerosPares;
	}
}