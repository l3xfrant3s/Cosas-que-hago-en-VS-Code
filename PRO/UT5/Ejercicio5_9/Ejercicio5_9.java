package PRO.UT5.Ejercicio5_9;

import PRO.ArrayTools;

public class Ejercicio5_9 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5};
        rotarDerecha(vector, 3);
        ArrayTools.imprimirArray(vector);
        rotarIzquierda(vector, 3);
        ArrayTools.imprimirArray(vector);
    }
    
    public static void rotarDerecha(int[] numeros){
        int temp = numeros[numeros.length-1];
        for(int i = numeros.length-1; i > 0; i--){
            numeros[i] = numeros[i-1];
        }
        numeros[0]=temp;
	}

    public static void rotarDerecha(int[] numeros, int veces){
        for(int i = 0; i < veces; i++){
            int temp = numeros[numeros.length-1];
            for(int j = numeros.length-1; j > 0; j--){
                numeros[j] = numeros[j-1];
            }
            numeros[0]=temp;
        }
	}

    public static void rotarIzquierda(int[] numeros){
        int temp = numeros[0];
        for(int i = 0; i < numeros.length-1; i++){
            numeros[i] = numeros[i+1];
        }
        numeros[numeros.length-1]=temp;
	}

    public static void rotarIzquierda(int[] numeros, int veces){
        for(int i = 0; i < veces; i++){
            int temp = numeros[0];
            for(int j = 0; j < numeros.length-1; j++){
                numeros[j] = numeros[j+1];
            }
            numeros[numeros.length-1]=temp;
        }
	}
}