package PRO.Calentador;

public class Calentador {
    private int temperatura, minimo, maximo, incremento;
    public Calentador(int elMinimo, int elMaximo){
        temperatura = 15;
        if(elMinimo > 15){temperatura = elMinimo;}
        if(elMaximo < 15){temperatura = elMaximo;}
        minimo = elMinimo;
        maximo = elMaximo;
        incremento = 5;
    }
    public void calentar(){
        if(temperatura + incremento > maximo) return;
        temperatura += incremento;
    }
    public void enfriar(){
        if(temperatura - incremento < minimo) return;
        temperatura -= incremento;
    }
    public int getTemperatura(){return temperatura;}
    public void setIncremento(int elIncremento){
        if(incremento < 1) return;
        incremento = elIncremento;
    }
}