package PRO.UT3.Calculadora;

public class EjemploCalculadora{
    public static void main(String[] args){
        Calculadora miCalculadora = new Calculadora();
        SOP("Introduciendo 20");
        miCalculadora.introducirNumero(20);
        SOP("Introduciendo 40");
        miCalculadora.introducirNumero(40);
        SOP("Introduciendo 5");
        miCalculadora.introducirNumero(5);
        SOP(miCalculadora.getCantidad() + "");
        SOP(miCalculadora.getMaximo() + "");
        SOP(miCalculadora.getMinimo() + "");
        SOP(miCalculadora.getMedia() + "");
    }
    public static void SOP(String aImprimir){System.out.println(aImprimir);}
}