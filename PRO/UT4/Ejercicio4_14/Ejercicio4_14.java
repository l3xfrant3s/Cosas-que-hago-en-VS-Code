package PRO.UT4.Ejercicio4_14;

public class Ejercicio4_14 {
    public static void main(String[] args){
        int temp = 0;
        escribirNumero(10, 30);
        mostrarPares();
        temp = generarAleatorios();
        SOPLN("El número 12 apareció " + temp + " ve" + (temp==1?"z":"ces"));
        SOPLN(sumarSerie(5)+"");
        SOPLN(sumarSerieAlt(5)+"");
        SOPLN(sumarDivisores(100)+""); //1+2+4+5+10+20+25+50+100
        SOPLN(sumarDigitos(345)+"");

    }

    public static void escribirNumero(int desde, int hasta){
        int cuenta = desde;
        while (cuenta <= hasta){
            SOPLN(cuenta+"");
            cuenta++;
        }
    }
    
    public static void mostrarPares(){
        int cuenta = 2;
        while (cuenta <= 50){
            if(cuenta % 2 == 0) SOPLN(cuenta+"");
            cuenta++;
        }
    }
    
    public static int generarAleatorios(){
        int iteraciones = 0;
        int numero = 0;
        int cuenta12 = 0;
        while(iteraciones < 30 || numero != 99){
            numero = (int) (Math.random() * 100) + 1;
            if(numero == 12)cuenta12++;
            SOPLN(numero+"");
            iteraciones++;
        }
        return cuenta12;
    }
    
    public static double sumarSerie(int n){
        int dividendo = 0;
        double suma = 0;
        while (dividendo < n){
            dividendo++;
            suma += 1.0 / dividendo;
        }
        return suma;
    }
    
    public static double sumarSerieAlt(int n){
        int i = 0;
        double suma = 0;
        while (i < n){
            i++;
            if(i % 2 == 0)suma -= 1.0 / i;
            else suma += 1.0 / i;
        }
        return suma;
    }
    
    public static int sumarDivisores(int numero){
        int suma = 1+numero;
        int divisor = 2;
        while(divisor <= numero/2+1){
            if (numero % divisor == 0){
                suma += divisor;
            }
            divisor++;
        }
        return suma;
    }
    
    public static int sumarDigitos(int numero){
        int suma = 0;
        int divisor = 10;
        int comp = 1;
        while(true){
            //System.out.println(numero%divisor);
            suma += (numero % divisor)/comp;
            if(divisor >= numero)break;
            divisor *= 10;
            comp *= 10;
        }
        return suma;
    }
    
    /*public static int sumarComponentesPrimos(int numero){
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
    }*/

    public static void SOPLN(String aImprimir){
        System.out.println(aImprimir);
    }
}