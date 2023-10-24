package PRO.Numero;

public class PruebaNumero {
    public static void main(String[] args){
        Numero dePrueba = new Numero();
        SOPLN(dePrueba.getNumero()+"");
        dePrueba.setNumero(456);
        SOPLN(dePrueba.esPar() ? "Es par" : "Es impar");
        SOPLN(dePrueba.getNumero()+"");
        SOPLN(dePrueba.getUltimaCifra()+"");
        SOPLN(dePrueba.obtenerUltimaCifras()+"");
    }
    public static void SOPLN(String aImprimir){System.out.println(aImprimir);}
}
