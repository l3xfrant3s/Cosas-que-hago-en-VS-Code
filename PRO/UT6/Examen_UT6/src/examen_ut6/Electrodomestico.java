package examen_ut6;

/*Originalmente había implementado el color con un enum, pero me di cuenta de que
si lo hago así, comprobarColor() es redundante porque el programa ya tiraba error cuando se
usa un valor erróneo*/

public class Electrodomestico{ 
    private final int PRECIO = 100;
    private String codigo, color;
    private char consumo;
    private boolean encendido;
    private double peso;
    private String[] ecologico;
    private int cuantas;
    
    public Electrodomestico(String codigo, String color, char consumo, double peso){
        this.codigo = codigo;
        this.color = color;
        comprobarColor();
        this.consumo = Character.toUpperCase(consumo);
        comprobarConsumo();
        this.encendido = false;
        this.peso = peso;
        this.ecologico = new String[5];
        this.cuantas = 0;
    }

    public String getCodigo(){
        return codigo;
    }
    public int getPrecio(){
        return PRECIO;
    }
    public String getColor(){
        return color;
    }
    public char getConsumo(){
        return consumo;
    }
    public boolean isEncendido(){
        return encendido;
    }
    public double getPeso(){
        return peso;
    }
    public String[] getEcologico(){
        return ecologico;
    }
    public int getCuantas() {
        return cuantas;
    }
    
    private boolean comprobarColor(){
        if (color.equals("Blanco") || color.equals("Negro") || 
            color.equals("Azul") || color.equals("Rojo") ||
            color.equals("Gris")) return true;
        
        color = "Blanco";
        return false;
    }
    
    private boolean comprobarConsumo(){
        if (consumo == 'A' || consumo == 'B' || consumo == 'C' ||
            consumo == 'D' || consumo == 'E' || consumo == 'F') return true;
        
        /*else if (consumo == 'a' || consumo == 'b' || consumo == 'c' ||
            consumo == 'd' || consumo == 'e' || consumo == 'f'){
            consumo = Character.toUpperCase(consumo);
            return true;
        }*/
        
        consumo = 'F';
        return false;
    }
    
    @Override
    public String toString(){
        String aDevolver ="Código: "+codigo+" de color "+color+" y peso "+
                peso+" kilos.\nConsumo: "+consumo+" y precio base "+
                PRECIO+" euros.\nTiene las siguientes caracteristicas:";
        for(int i = 0; i < cuantas; i++){
            aDevolver += "\n"+ecologico[i];
        }
        return aDevolver;
    }
    
    public void encender(){encendido = !encendido;}
    
    public boolean aniadirCaracteristica(String carac){
        if(cuantas >= 5) return false;
        for(int i = 0; i < cuantas; i++){
            if(carac.equals(ecologico[i])) return false;
        }
        ecologico[cuantas++] = carac;
        return true;
    }
}