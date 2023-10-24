public class PruebaVisor {
    public static void main(String[] args){
        RelojAlarma relojAlarma = new RelojAlarma();
        relojAlarma.setAlarma(0, 1);
        relojAlarma.getHora();
        while(true){
            try{
            Thread.sleep(1000);
            relojAlarma.emitirTic();
            }
            catch(Exception e){}
        }
    }
}