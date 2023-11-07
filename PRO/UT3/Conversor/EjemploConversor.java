package PRO.UT3.Conversor;

public class EjemploConversor{
    public static void main (String[] args){
        Conversor enCentigrados = new Conversor();
        enCentigrados.setGrados(33); //La temperatura de hoy en Las Palmas
        Conversor enFahrenheit = new Conversor();
        enFahrenheit.setGrados(58); //La temperatura de hoy en Nueva York en Fahrenheit
        System.out.println("Today it's " + enCentigrados.aFahrenheit() + " degrees Fahrenheit in Gran Canaria");
        System.out.println("Hoy hay " + enFahrenheit.aCentigrados() + " grados Centigrados en Nueva York");
    }
}
