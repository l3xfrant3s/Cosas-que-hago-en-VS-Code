

public class prueba2{

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = new int[4];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        //b = a;
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
        b[0] = 5;
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + ",");
        }
    }
}