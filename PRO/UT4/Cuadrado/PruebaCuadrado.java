package PRO.UT4.Cuadrado;

public class PruebaCuadrado {
    public static void main(String[] args) {
        Cuadrado pintor = new Cuadrado(9);
        pintor.dibujarEnAspa();
        System.out.println("\n");
        pintor.dibujarBicolor();
        System.out.println("\n");
        pintor.dibujarContorno();
    }
}
