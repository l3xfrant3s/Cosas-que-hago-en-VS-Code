public class cosa{
    public static int preciocarbon(int niveles, int inicial){
        int total = 0;
        String composicion = "";
        for(int i = inicial; i < niveles; i++){
            total+=80+20*i;
            composicion += 80+20*i+(i+1==niveles?" = "+total:" + ");
        }
        System.out.println(composicion);
        return total;
    }

    public static void main(String[] args) {
        preciocarbon(10,4);
    }
}