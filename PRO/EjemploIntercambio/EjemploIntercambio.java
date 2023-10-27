package PRO.EjemploIntercambio;

public class EjemploIntercambio{
    public static void main(String[] args){
        Ejemplo exempliGratia = new Ejemplo(12, 33);
        exempliGratia.promptAntes();
        exempliGratia.escribir();
        exempliGratia.promptDespues();
        exempliGratia.intercambiar();
        exempliGratia.escribir();
    }
}