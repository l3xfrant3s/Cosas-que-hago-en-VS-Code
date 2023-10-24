package PRO.Calentador;
public class PruebaCalentador{
    public static void main(String[] args){
        Calentador dropShippeado = new Calentador(0,100);
        SOPLN(dropShippeado.getTemperatura()+"");
        dropShippeado.calentar();
        SOPLN(dropShippeado.getTemperatura()+"");
        dropShippeado.setIncremento(20);
        dropShippeado.enfriar();
        dropShippeado.enfriar();
        SOPLN(dropShippeado.getTemperatura()+"");
        dropShippeado.calentar();
        dropShippeado.calentar();
        dropShippeado.calentar();
        dropShippeado.calentar();
        dropShippeado.calentar();
        dropShippeado.calentar();
        dropShippeado.calentar();
        SOPLN(dropShippeado.getTemperatura()+"");
        dropShippeado.setIncremento(10);
        dropShippeado.setIncremento(-10);
        dropShippeado.calentar();
        dropShippeado.calentar();
        SOPLN(dropShippeado.getTemperatura()+"");
        dropShippeado.enfriar();
        dropShippeado.enfriar();
        SOPLN(dropShippeado.getTemperatura()+"");
    }
    public static void SOPLN(String aImprimir){
        System.out.println(aImprimir);
    }
}