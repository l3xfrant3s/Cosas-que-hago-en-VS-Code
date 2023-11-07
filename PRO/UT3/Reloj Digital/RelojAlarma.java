public class RelojAlarma {
    private VisorReloj reloj;
    private Alarma alarma;

    public RelojAlarma(){
        reloj = new VisorReloj();
        alarma = new Alarma();
    }

    public RelojAlarma(int hora, int minuto, int segundo){
        reloj = new VisorReloj(hora, minuto, segundo);
        alarma = new Alarma();
    }

    public void emitirTic(){
        reloj.emitirTic();
        if(esHoraAlarma())System.out.println("RRRRIIIIINNNNNGGGGG");
    }
    
    public void setHora(int hora, int minuto, int segundo){
        reloj.ponerEnHora(hora, minuto, segundo);
    }

    public void setAlarma(int hora, int minuto){
        alarma.setHoraAlarma(hora, minuto);
    }

    public String getHora(){
        return reloj.getHora();
    }

    public String getAlarma(){
        return alarma.getHoraAlarma();
    }
    
    private boolean esHoraAlarma(){
        return this.reloj.getHoraSinSegundos().equals(this.getAlarma());
    }
    
}
