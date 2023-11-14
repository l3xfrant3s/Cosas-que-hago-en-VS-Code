package PRO.UT5.Ejercicio5_11;

import java.util.Random;

import PRO.ArrayTools;

public class Ejercicios5_11 {
    static Random generador = new Random();

    public static void main(String[] args) {
        int[] frequencies = calcularFrecuencias();
        //ArrayTools.imprimirArray(frequencies);
        for(int i = 0;i < frequencies.length; i++){
            System.out.printf("El número %d apareció %d ve"+(frequencies[i]==1?"z.\n":"ces.\n"),i+1,frequencies[i]);
        }
    }

    public static int[] calcularFrecuencias(){
		int[] frecuencias = new int[9];
        int temp = 0;
        for (int i = 0; i < 100; i++){
            temp = generador.nextInt(9);
            frecuencias[temp]++;
        }
        return frecuencias;
	}
}
