package PRO.UT5.Ejercicio5_9;

import PRO.ArrayTools;

public class Ejercicio5_9 {
    public static void main(String[] args) {
        int[] vector = {1,2,3,4,5};
        rotarDerecha(vector, 3);
        rotarIzquierda(vector, 3);
        rotarIzquierda(vector, 2);
        rotarDerecha(vector, 3);
    }
    
    public static void rotarDerecha(int[] numeros){
        //ArrayTools.imprimirArray(numeros);
        int temp = numeros[numeros.length-1];
        for(int i = numeros.length-1; i > 0; i--){
            numeros[i] = numeros[i-1];
        }
        numeros[0]=temp;
	}

    public static void rotarDerecha(int[] numeros, int veces){
        for(int i = 0; i < veces; i++){
            rotarDerecha(numeros);
            //for(int j = 0; j < veces-i; j++)System.out.print(">");
            //System.out.print("\n");
        }
        ArrayTools.imprimirArray(numeros);
        System.out.print("\n");
	}

    public static void rotarIzquierda(int[] numeros){
        int temp = numeros[0];
        //ArrayTools.imprimirArray(numeros);
        for(int i = 0; i < numeros.length-1; i++){
            numeros[i] = numeros[i+1];
        }
        numeros[numeros.length-1]=temp;
	}

    public static void rotarIzquierda(int[] numeros, int veces){
        for(int i = 0; i < veces; i++){
            //for(int j = 0; j < i; j++)System.out.print(" ");
            //for(int j = 0; j < veces-i; j++)System.out.print("<");
            
            rotarIzquierda(numeros);
            //System.out.print("\n");
        }
        //for(int j = 0; j < veces; j++)System.out.print(" ");
        ArrayTools.imprimirArray(numeros);
        System.out.print("\n");
	}
}