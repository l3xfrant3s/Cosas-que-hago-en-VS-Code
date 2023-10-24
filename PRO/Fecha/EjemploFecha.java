public class EjemploFecha{
    public static void main (String[] args){
        Fecha hoy= new Fecha(15, 6, 2016);
        System.out.printf("Hoy es el %s y "+(hoy.esCorrecta()?"":"no ")+"es una fecha real."+
        "\nEste mes tiene %d días.\nEl año"+(hoy.esBisiesto()?"":" no")+" es bisiesto.\n",hoy, hoy.diasMes());
        Fecha antier= new Fecha(31, 11, 2023);
        System.out.printf("Hoy es el %s y "+(antier.esCorrecta()?"":"no ")+"es una fecha real."+
        "\nEste mes tiene %d días.\nEl año"+(antier.esBisiesto()?"":" no")+" es bisiesto.\n",antier, antier.diasMes());
    }
}