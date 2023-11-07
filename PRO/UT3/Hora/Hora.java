package PRO.UT3.Hora;

public class Hora {
    private int horas,minutos,segundos;
    public Hora(){
        horas = 0;
        minutos = 0;
        segundos = 0;
    }
    public void setHoras(int lasHoras){
        if(lasHoras>=0&&lasHoras<=23)horas=lasHoras;
    }
    public void setMinutos(int losMinutos){
        if(losMinutos>=0&&losMinutos<=59)minutos=losMinutos;
    }
    public void setSegundos(int losSegundos){
        if(losSegundos>=0&&losSegundos<=59)segundos=losSegundos;
    }
    public int getHoras(){return horas;}
    public int getMinutos(){return minutos;}
    public int getSegundos(){return segundos;}
    
    public void avanzarSegundo(){
        if(segundos == 59){
            segundos = 0;
            if(minutos == 59){
                minutos = 0;
                if(horas == 23){
                    horas = 0;
                    return;
                }
                horas++;
                return;

            }
            minutos++;
            return;
        }
        segundos++;
    }

    @Override
    public String toString(){
        return (horas<10?"0"+horas:horas+"") +":"+ (minutos<10?"0"+minutos:minutos+"") +":"+ (segundos<10?"0"+segundos:segundos+"");
        //return horas + ":" + minutos + ":" + segundos;
    }
}
