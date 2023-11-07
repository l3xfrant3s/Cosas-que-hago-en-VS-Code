package PRO.UT3.Punto;

public class EjemploPunto{
    public static void main(String[] args){
        Punto ejesDefecto = new Punto();
        Punto ejesInicializacion = new Punto(3, 4, 5);
        Punto ejesCopia = new Punto(ejesInicializacion);
        ejesInicializacion.setY(24);
        ejesInicializacion.setZ(-5);
        Punto ejesConversion = new Punto(42);
        System.out.println("Así se ve el constructor por defecto: " +  ejesDefecto);
        System.out.println("Así se ve el constructor de inicialización: " + ejesInicializacion);
        System.out.println("Así se ve el constructor copia: " + ejesCopia);
        System.out.println("Así se ve el constructor por conversión: " + ejesConversion);
    }
}