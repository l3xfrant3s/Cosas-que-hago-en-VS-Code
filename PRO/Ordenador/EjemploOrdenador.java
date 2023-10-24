public class EjemploOrdenador{
    public static void main(String[] args){
        Ordenador gayming = new Ordenador(960);
        SOPLN(gayming.getMaxMemoria() + " MB de memoria máxima");
        SOPLN("Puedo instalar otros " + gayming.getMemoriaDisponible() + " MB");
        SOPLN(gayming.instalar256Mb() ? "OK":"No se pudieron instalar 256 Mb");
        SOPLN("Puedo instalar otros " + gayming.getMemoriaDisponible() + " MB");
        SOPLN(gayming.instalarMemoria(168) ? "OK":"No se pudieron instalar 168 Mb");
        SOPLN("Puedo instalar otros " + gayming.getMemoriaDisponible() + " MB");
        gayming.vaciarMemoria();        
        SOPLN("Puedo instalar otros "+ gayming.getMemoriaDisponible() + " MB");
        gayming.printInformacion();
    }
    
    public static void SOPLN (String aImprimir){
        System.out.println(aImprimir);
    }
}
