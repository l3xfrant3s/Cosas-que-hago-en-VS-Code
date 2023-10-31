package PRO.Ejercicio4_16;

public class Ejercicio4_16 {
    public static void main(String[] args){
        contarParesImpares();
        System.out.println(maximo(5));
        escribirEstadisticas();
    }

    public static void contarParesImpares(){
        int cuentaPares = 0;
        int cuentaImpares = 0;
        for(int i = 0; i < 20; i++){
            int numero = (int) (Math.random() * 49) + 1;
            //System.out.println(numero);
            if(numero%2==0)cuentaPares++;
            else cuentaImpares++;
        }
       System.out.printf("Han aparecido %d número"+(cuentaPares==1?" par":"s pares")+" y %d número"+(cuentaImpares==1?" impar":"s impares")+".\n", cuentaPares, cuentaImpares);
    }
    
    public static int  maximo(int cuantos){
        int maximo = 0;
        for (int i = 0; i < cuantos; i++){
            int aleatorio = (int) (Math.random() * 100) + 1;
            maximo = aleatorio>maximo?aleatorio:maximo;
        }
        return maximo;
    }

    public static void escribirEstadisticas(){
        final int MAX = 30;
        double media = 0;
        int cuentaMaximo = 0;
        int cuentaMinimo = 0;
        int maximo = 0;
        int minimo = 10;
        for (int i = 0; i < 30; i++){
            int aleatorio = (int) (Math.random() * 10) + 1;
            media += aleatorio;
            if(aleatorio == maximo){cuentaMaximo++;}
            if(aleatorio == minimo){cuentaMinimo++;}
            if(aleatorio > maximo){
                maximo = aleatorio;
                cuentaMaximo = 1;
            }
            if(aleatorio < minimo){
                minimo = aleatorio;
                cuentaMinimo = 1;
            }
        }
        media /= MAX;
        System.out.println("La nota media ha sido de "+media+", con una nota mínima de "+minimo+
        " que ha aparecido "+cuentaMinimo+" ve"+(cuentaMinimo==1?"z":"ces")+" y una nota máxima de "+
        maximo+" que ha aparecido "+cuentaMaximo+" ve"+(cuentaMaximo==1?"z.":"ces."));

    }
}
