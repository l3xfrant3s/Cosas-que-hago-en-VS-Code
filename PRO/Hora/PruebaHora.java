package PRO.Hora;

public class PruebaHora{
    public static void main (String[] args) {
        Hora dePrueba = new Hora();
        for(int i = 0; i < 86400; i++){
            switch (i){
                case 9:SOPLN(dePrueba.toString());break;
                case 59:SOPLN(dePrueba.toString());break;
                case 599:SOPLN(dePrueba.toString());break;
                case 3599:SOPLN(dePrueba.toString());break;
                case 18645:SOPLN(dePrueba.getHoras()+":"+dePrueba.getMinutos()+":"+dePrueba.getSegundos());break;
                case 35999:SOPLN(dePrueba.toString());break;
                case 86399:SOPLN(dePrueba.toString());break;
            }
            dePrueba.avanzarSegundo();
        }
        SOPLN(dePrueba.toString());
    }
    public static void SOPLN(String aImprimir){
        System.out.println(aImprimir);
    }
}