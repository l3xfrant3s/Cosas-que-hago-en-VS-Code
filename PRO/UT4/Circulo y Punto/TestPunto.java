public class TestPunto {
    public static void test(){
        Punto2 p1 = new Punto2(3, 8);
        Punto2 p2 = new Punto2(12, 9);
        System.out.println("Punto 1: "+p1+"\nPunto 2: "+p2);
        System.out.println("Distancia desde el primer punto hasta el origen: " + p1.getDistanciaDesdeOrigen());
        System.out.println("Distancia entre los puntos 1 y 2: " + p1.getDistanciaDesde(p2));
    }
}
