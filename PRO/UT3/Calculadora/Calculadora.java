package PRO.UT3.Calculadora;

public class Calculadora{
    
    private int cantidad, suma, maximo, minimo;
    
    public Calculadora(){
        cantidad = 0;
        suma = 0;
        maximo = 0;
        minimo = 0;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public int getMaximo(){
        return maximo;
    }
    
    public int getMinimo(){
        return minimo;
    }
    
    public void introducirNumero(int numero){
        cantidad++;
        suma += numero;
        if(cantidad == 1) maximo = minimo = numero;
        if(numero > maximo) maximo = numero;
        if(numero < minimo) minimo = numero;
    }
    public double getMedia(){
        return suma*1.0 / cantidad;
    }
}