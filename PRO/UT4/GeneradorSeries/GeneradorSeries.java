package PRO.UT4.GeneradorSeries;

public class GeneradorSeries {
    private final char[] alfabeto = {'A', 'B', 'C', 'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
    public GeneradorSeries(){}

    private void lineaAlfabeto(int primeraLetra){
        for (int i = 0; i < 10; i++) System.out.println("   "+alfabeto[primeraLetra+i]);
    }

    public void serieAlfabeto(){

    }

    public void serieLetras(){

    }

    public void serieAlterna(int numFilas, int numColumnas){

    }
}