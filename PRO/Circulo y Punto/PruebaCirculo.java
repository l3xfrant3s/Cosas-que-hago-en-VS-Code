public class PruebaCirculo {
    public static void main(String[] args){
        Circulo inutil = new Circulo (5);
        System.out.println(inutil);
        System.out.println(inutil.calcularPerimetro());
        System.out.println(inutil.calcularArea());
        TestPunto.test();
    }
}
