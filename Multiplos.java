public class Multiplos {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++){
            int j = 0;
            if(i%3 == 0){
                if(i%4 == 0){
                    if(i%5 == 0){
                        if(i%7 == 0){
                            System.out.println(i);
                        }
                    }
                }
            }
        }
    }
}
