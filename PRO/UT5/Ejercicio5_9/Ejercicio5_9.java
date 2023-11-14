package PRO.UT5.Ejercicio5_9;

import PRO.ArrayTools;

public class Ejercicio5_9 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5};
        rotarDerecha(vector);
        ArrayTools.imprimirArray(vector);
    }
    
    public static void rotarDerecha(int[] numeros){
        int temp = numeros[numeros.length-1];
        for(int i = numeros.length-1; i > 0; i--){
            numeros[i] = numeros[i-1];
        }
        numeros[0]=temp;
	}

}