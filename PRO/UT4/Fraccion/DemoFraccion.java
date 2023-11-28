package PRO.UT4.Fraccion;

public class DemoFraccion {
    private Fraccion fraccion1, fraccion2;

    public DemoFraccion(){
        fraccion1 = new Fraccion();
        fraccion1.setNumerador(-4);
        fraccion1.setDenominador(7);
        fraccion2 = new Fraccion(13, 2);
    }
    public void demo1(){
        Fraccion Suma = fraccion1.sumar(fraccion2);
        Fraccion Resta = fraccion1.restar(fraccion2);
        Fraccion Multiplicacion = fraccion1.multiplicar(fraccion2);
        Fraccion Division = fraccion1.dividir(fraccion2);
        escribirFraccion("Suma de fraccion1 y fraccion2: ", Suma);
        escribirFraccion("Resta de fraccion1 y fraccion2: ", Resta);
        escribirFraccion("Multiplicacion de fraccion1 y fraccion2: ", Multiplicacion);
        escribirFraccion("Division de fraccion1 y fraccion2: ", Division);
    }

    public void demo2(){
        fraccion1.setNumerador(17);
        fraccion1.setDenominador(25);
        fraccion2.setNumerador(16);
        fraccion2.setDenominador(11);
        if(fraccion1.igualQue(fraccion2)){
            escribirFraccion("fraccion 1", fraccion1);
        }
    }

    private void escribirFraccion(String mensaje, Fraccion fraccion){
        System.out.println(mensaje + fraccion.toString());
    }
}