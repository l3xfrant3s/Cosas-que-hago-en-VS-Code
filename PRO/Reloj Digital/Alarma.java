public class Alarma {
    private int horas, minutos;
    public Alarma(){
        horas = 7;
        minutos = 0;
    }
    public void setHoraAlarma(int h, int m){
        if(h > 23 || h < 0 || m > 59 || m < 0) return;
        horas = h;
        minutos = m;
    }

    public String getHoraAlarma(){
        return (horas<10?"0":"")+horas+":"+(minutos<10?"0":"")+minutos;
    }
}