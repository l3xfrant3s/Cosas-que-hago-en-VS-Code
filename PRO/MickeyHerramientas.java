package PRO;

public class MickeyHerramientas {

    public static int[] copiarArray(int[] array, int limite){
        int[] copia = new int[limite];
        for(int i = 0; i < limite; i++)copia[i] = array[i];
        return copia;
    }

    public static double[] copiarArray(double[] array, int limite){
        double[] copia = new double[limite];
        for(int i = 0; i < limite; i++)copia[i] = array[i];
        return copia;
    }

    public static void invertirArray(int[] array) {
        int temp = 0;
        for(int i = 0; i < array.length/2; i++){
            temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }

    public static void imprimirArray(int[] array){
        if(array.length == 0){System.out.println("{}");return;}
        String elArray = "{";
        for(int i = 0; i < array.length; i++){
            elArray += array[i]+(i==array.length-1?"}":",");
        }
        System.out.print(elArray);
    }

    public static void imprimirArray(int[] array, int limite){
        if(limite == 0 || array.length == 0){System.out.println("{}\n");return;}
        String elArray = "{";
        for(int i = 0; i < limite; i++){
            elArray += array[i]+(i==limite-1?"}":",");
        }
        System.out.print(elArray);
    }
}