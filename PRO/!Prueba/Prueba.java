public class Prueba {
    public static void main(String[] args){
        int[] test = new int[]{1,2,3,4,5};
        invertirArray(test);
        imprimirArray(test);
    }
    public static void invertirArray(int[] array) {
        int limite = array.length%2==0?array.length/2:array.length/2+1;
        int temp = 0;
        for(int i = 0; i < limite; i++){
            temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }
    public static void imprimirArray(int[] array){
        if(array.length == 0){System.out.println("{}\n");return;}
        String elArray = "{";
        for(int i = 0; i < array.length; i++){
            elArray += array[i]+(i==array.length-1?"}\n":",");
        }
        System.out.println(elArray);
    }

    public static void imprimirArray(int[] array, int limite){
        if(limite == 0 || array.length == 0){System.out.println("{}\n");return;}
        String elArray = "{";
        for(int i = 0; i < limite; i++){
            elArray += array[i]+(i==limite-1?"}\n":",");
        }
        System.out.println(elArray);
    }
}