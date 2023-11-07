package PRO.UT3.Numero;

public class Numero {
    private int numero;
    public Numero(){numero = 999;}

    public int getNumero(){return numero;}

    public void setNumero(int cualNumero){
        if(cualNumero >= 100 && cualNumero <= 999)numero = cualNumero;
    }

    public boolean esPar(){return numero % 2 == 0;}

    public int getUltimaCifra(){return numero%10;}

    public int obtenerUltimaCifras(){
        return numero/100 + numero/10%10 + getUltimaCifra();
    }
}
