public class Prueba {
    public static void main(String[] args){
        System.out.println(sumarDivisores(13));
        System.out.println(sumarDivisores(21));
        System.out.println(sumarDivisores(100));

    }

    public static int sumarDivisores(int numero){
        int suma = 0;
        int copiaNumero = numero;
        int divisor = 2;
        while(copiaNumero != 1){
            if (copiaNumero % divisor == 0){
                suma += divisor;
                copiaNumero /= divisor;
                divisor = 1;
            }
            divisor++;
        }
        return suma;
    }
}