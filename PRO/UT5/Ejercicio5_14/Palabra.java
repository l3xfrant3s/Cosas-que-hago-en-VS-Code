package PRO.UT5.Ejercicio5_14;

public class Palabra{
    private String ingles, castellano;
    public Palabra(String es, String in){
        ingles = in;
        castellano = es;
    }
    public String getCastellano() {
        return castellano;
    }
    public String getIngles() {
        return ingles;
    }

    @Override
    public String toString(){
        return castellano + " - " + ingles;
    }
}