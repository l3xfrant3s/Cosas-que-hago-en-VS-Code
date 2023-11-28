package PRO.UT4.PintorFiguras;

public class PintorFiguras {
    private final char BLANCO = ' ';
    private final char NEGRO = '*';

    public PintorFiguras(){
    }

    private void lineaAjedrez(boolean esBlanco){
        String blanco = ""+BLANCO+BLANCO+BLANCO+BLANCO;
        String negro = ""+NEGRO+NEGRO+NEGRO+NEGRO;
        if(esBlanco) System.out.println(blanco+negro+blanco+negro+blanco+negro+blanco+negro);
        else System.out.println(negro+blanco+negro+blanco+negro+blanco+negro+blanco);
    }

    private int contar09(int n){
        n++;
        if(n>9)n=0;
        return n;
    }

    private int contar90(int n){
        n--;
        if(n<0)n=9;
        return n;
    }

    private void lineaArbolNavidad(int n){
        int numero = n;
        if(n < 1 || n > 9){System.out.println("       000       ");return;}
        int limite = 2*n-1;
        String espacios = "";
        for(int i = 0; i < 9-n; i++){
            espacios += " ";
        }
        String numeros = "";
        for (int i = 1; i < limite+1; i++){
            //System.out.println(numero);
            numeros += numero;
            if(i >= n) {
                numero = contar90(numero);
                //System.out.println("reducir");
            }
            else {
                numero = contar09(numero);
                //System.out.println("aumentar");
            }
        }
        System.out.println(espacios+numeros+espacios);
    }

    public void dibujarTableroAjedrez(){
        boolean esBlanco = true;
        for(int i = 1; i < 25; i++){
            lineaAjedrez(esBlanco);
            if(i%3==0)esBlanco = !esBlanco;
        }
    }

    public void dibujarArbolNavidad(){
        for(int i = 1; i < 12; i++){
            lineaArbolNavidad(i);
        }
    }
}