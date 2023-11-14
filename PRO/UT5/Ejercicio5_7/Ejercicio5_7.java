package PRO.UT5.Ejercicio5_7;

public class Ejercicio5_7 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(maximoDeArray(array));
        int[] array2 = {-1,-2,-3,-4,-5};
        System.out.println(maximoDeArray(array2));
        int[] array3 = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE+1};
        System.out.println(maximoDeArray(array3));
    }

    public static int maximoDeArray(int[] vector){
        int maximo = Integer.MIN_VALUE;
        int limite = vector.length%2==0?vector.length/2:vector.length/2+1;
        for(int i=0; i<limite; i++){
            if(vector[i]>maximo)maximo=vector[i];
            if(vector[vector.length-1-i]>maximo)maximo=vector[vector.length-1-i];
        }
        return maximo;
    }
}