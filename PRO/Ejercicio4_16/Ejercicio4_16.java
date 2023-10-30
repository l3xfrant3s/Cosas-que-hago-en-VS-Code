package PRO.Ejercicio4_16;

public class Ejercicio4_16 {
    public static void main(String[] args){
        contarParesImpares();
    }

    public static void contarParesImpares(){
        int cuentaPares = 0;
        int cuentaImpares = 0;
        for(int i = 0; i < 20; i++){
            int numero = (int) (Math.random() * 49) + 1;
            System.out.println(numero);
            if(numero%2==0)cuentaPares++;
            else cuentaImpares++;
        }
       System.out.printf("Han aparecido %d número"+(cuentaPares==1?" par":"s pares")+" y %d número"+(cuentaImpares==1?" impar":"s impares")+".\n", cuentaPares, cuentaImpares);
    }
    
    public static int  maximo(){return 1;}
    public static void escribirEstadisticas(){}
}
