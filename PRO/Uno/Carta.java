package PRO.Uno;



public class Carta {
    private int numero;
    private Color color;
    private Tipo tipo;
    public static final int PIERDE_TURNO = 0;
    public static final int CAMBIAR_SENTIDO = 1;
    public static final int MAS_DOS = 2;
    public static final int CAMBIAR_COLOR = 0;
    public static final int MAS_CUATRO = 1;


    public Carta(int numero, String color){
        this.numero = numero;
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    public String toString(){
        String 
    }
}