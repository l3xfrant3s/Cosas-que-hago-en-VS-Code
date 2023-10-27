package PRO.Fecha;

import java.util.GregorianCalendar;

public class Fecha{
    private int dia, mes, anio;
    
    public Fecha(int d, int m, int a){
        dia = d;
        mes = m;
        anio = a;
        if(!esCorrecta())ponerFechaSistema();
    }

    public void setDia(int queDia){
        int diaActual = dia;
        dia = queDia;
        if(!esCorrecta()) dia = diaActual;
    }

    public void setMes(int queMes){
        int mesActual = mes;
        mes = queMes;
        if(!esCorrecta()) mes = mesActual;
    }

    public void setAnio(int queAnio){
        if(queAnio != 0)anio = queAnio;
    }

    public int getDia(){return dia;}

    public int getMes(){return mes;}

    public int getAnio(){return anio;}
    
    public boolean esBisiesto(){
        return anio%4==0 && anio%100!=0 || anio%400==0;
    }
    
    public int diasMes(){
        switch (mes){
            case 1, 3, 5, 7, 8, 10 ,12: return 31;
            //case 2: if (esBisiesto()) return 29; else return 28;
            case 2: return esBisiesto()?29:28;
            case 4, 6, 9, 11: return 30;
            default: return 0;
        }
    }
    
    public String toString(){
        return dia + " - " + mes + " - " + anio;
    }

    public void printCorta(){
        System.out.println(this);
    }
    
    public void printLarga(){
        System.out.println(dia + " de " + nombreMes() + " de " + anio);
    }
    
    public boolean esCorrecta(){
        if(anio == 0) return false;
        if (mes >= 1 && mes <= 12){
            /*switch (mes){
                case 1, 3, 5, 7, 8, 10, 12: return dia <= 31 && dia >= 1;
                case 4, 6, 9, 11: return dia <= 30 && dia >= 1;
                case 2: if (dia >= 1){
                                return dia <= 29 && esBisiesto() || dia <= 28;
                        }
                default: return false;
            }*/
            return dia <= this.diasMes() && dia >= 1;
        }
        return false;
    }

    public void ponerFechaSistema(){
        dia = GregorianCalendar.DATE;
        mes = GregorianCalendar.MONTH+1;
        anio = GregorianCalendar.YEAR;
    }

    public String nombreMes(){
        switch (mes){
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Noexistero";
        }
    }
}