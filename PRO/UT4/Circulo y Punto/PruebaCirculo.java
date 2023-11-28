public class PruebaCirculo {
    public static void main(String[] args){
        Circulo redondo = new Circulo (5);
        System.out.println(redondo);
        System.out.println(redondo.calcularPerimetro());
        System.out.println(redondo.calcularArea());
        TestPunto.test();
    }
}