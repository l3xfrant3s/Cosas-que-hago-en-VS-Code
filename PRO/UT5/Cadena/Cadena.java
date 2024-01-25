package PRO.UT5.Cadena;

public class Cadena {
    private String laCadena;

    public Cadena(String S){
        laCadena = S;
    }

    public Cadena(Cadena C){
        laCadena = C.getLaCadena();
    }

    public String getLaCadena() {
        return laCadena;
    }

    public void setLaCadena(String laCadena) {
        this.laCadena = laCadena;
    }

    
}