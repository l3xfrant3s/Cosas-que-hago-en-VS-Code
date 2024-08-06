public class GoobooEmberCalculator{
    public static void main(String[] args){
        EmberUpToMetre(10);
    }

    public static int metresToTotalCarbon(int metres, boolean verbose){
        int copyMetres = metres-90;
        int carbon;
        if(copyMetres < 0){carbon = 0;}
        else{
            carbon = 10*(copyMetres+1)+(copyMetres*(copyMetres+1)/2);
        }

        if(verbose)System.out.printf("%d m -> %d Carbon\n", metres, carbon);

        return carbon;
    }

    public static int carbonToEmber(int carbon, boolean verbose){
        int copyCarbon = carbon;
        int spentCarbon = 0;
        int ember = 0;
        while(copyCarbon >= 80 + 3*ember){
            copyCarbon -= 80 + 3 * ember;
            spentCarbon += 80 + 3 * ember;
            ember++;
        }

        if(verbose)System.out.printf("%d Carbon -> %d Ember (%d Carbon)\n", carbon, ember, spentCarbon);

        return ember;
    }

    public static int metresToEmber(int metres, boolean verbose){
        return carbonToEmber(metresToTotalCarbon(metres, verbose), verbose);
    }

    public static int metresToEmber2(int metres){
        int carbon = metresToTotalCarbon(metres, false);
        int ember = carbonToEmber(carbon, false);
        System.out.printf("%d Ember %d m IDK Carbon\n", ember, metres);
        return ember;
    }

    public static void EmberUpToMetre(int ember){
        if(ember > 0){
            int m = 90;
            for(int e = 1; e <= ember; e++){
                while(true){
                    int test = metresToEmber(m, false);
                    if(test == e){
                        metresToEmber2(m);
                        m++;
                        break;
                    }
                    m++;
                }
            }
        }
    }
}