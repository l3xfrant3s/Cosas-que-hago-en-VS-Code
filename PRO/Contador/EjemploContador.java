package PRO.Contador;

public class EjemploContador{
    private int cuenta;
    private final int inicial;
    public EjemploContador(){
        cuenta = 0;
        inicial = 0;
    }
    public EjemploContador(int inicio){
        cuenta = inicio;
        inicial = inicio;
    }
    public void decrementar(){cuenta--;}
    public int getContador(){return cuenta;}
    public void incrementar(){cuenta++;}
    public void printContador(){
        System.out.println(cuenta);
    }
    public void reset(){
        cuenta = inicial;
    }
}
