package PRO.Ejercicio4_15;

public class Ejercicio4_15{

    public static void main(String[] args){
        System.out.println("escribirFiguraCuadrado:");
        escribirFiguraCuadrado(6);
        System.out.println("\nescribirFiguraEscalera:");
        escribirFiguraEscalera(6);
        System.out.println("\nescribirFiguraEscalera2:");
        escribirFiguraEscalera2(6);
        System.out.println("\nescribirTablaMultiplicar:");
        escribirTablaMultiplicar(6);
        System.out.println("\ncalcularSumatorios:");
        calcularSumatorios(6, 20);
        
    }

    public static void escribirFiguraCuadrado(int n){
        int o = 1;
        while(o <= n){
            int p = 1;
            while(p <= n){
                System.out.print(o+(p==n?"\n":" "));
                p++;
            }
            o++;
        }
    }

    public static void escribirFiguraEscalera(int n){
        int o = 1;
        while(o <= n){
            int p = 1;
            while(p <= o){
                System.out.print(o+(p==o?"\n":" "));
                p++;
            }
            o++;
        }
    }

    public static void escribirFiguraEscalera2(int n){
        int o = 1;
        while(o <= n){
            int p = 1;
            while(p <= o){
                System.out.print(p+(p==o?"\n":" "));
                p++;
            }
            o++;
        }
    }
    public static void escribirTablaMultiplicar(int numero){
        int multiplicando = 1;
        while(multiplicando <= numero){
            int multiplicador = 1;
            while(multiplicador <= numero){
                System.out.printf("%d x %d = %d\n", multiplicando, multiplicador, multiplicando*multiplicador);
                multiplicador++;
            }
            multiplicando++;
            if(multiplicando <= numero) System.out.println("--------------");
        }
    }

    public static void calcularSumatorios(int cuantos, int limite){
        int numero = 0;
        int iter = 0;
        while(iter < cuantos){
            numero = (int) (Math.random() * limite-1) + 1;
            int suma = numero;
            String frase = "sumatorio("+numero+")="+numero;
            while(numero > 1){
                suma += --numero;
                frase += "+"+numero;
            }
            frase += "="+suma;
            System.out.println(frase);
            iter++;
        }
    }
}