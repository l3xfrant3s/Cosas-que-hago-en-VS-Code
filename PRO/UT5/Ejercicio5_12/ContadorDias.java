package PRO.UT5.Ejercicio5_12;

public class ContadorDias {
    private final int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
    public ContadorDias(){}

    public int contarDias(int dia, int mes, int año){
        int dias = dia;
        for (int i = 0; i < mes-1; i++) dias += diasMes[i];
        return esBisiesto(año)?++dias:dias;
    }

    private boolean esBisiesto(int año){
        return año%4==0 && año%100!=0 || año%400==0;
    }
}