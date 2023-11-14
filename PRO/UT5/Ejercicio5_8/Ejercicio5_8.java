package PRO.UT5.Ejercicio5_8;

import PRO.ArrayTools;

public class Ejercicio5_8 {
    public static void main(String[] args) {
        int[] lista = {1,2,3,4,5,6,7,10,202};
        ArrayTools.imprimirArray(vectorPares(lista));//Imprime el array en formato {a,b,c...}
    }

    public static int[] vectorPares(int[] vector){
        int cuantosPares = 0;
        int[] arrayPares = new int[vector.length];
        for(int i=0; i<vector.length; i++){
            if(vector[i]%2==0){
                arrayPares[cuantosPares]=vector[i];
                cuantosPares++;
            }
        }
        return ArrayTools.copiarArray(arrayPares, cuantosPares);//Devuelve una copia del array del mismo tamaño que el limite
    }
}