
/**
 * La clase representa a circulos con un centro
 * y un valor determinado de radio
 * 
 * @autor 
 * @version 
 */
public class Circulo{
    private final double PI = 3.14159265358979323846;
    //private final double PI = 3.14;
    private double radio;
    private Punto centro;

     /**
     * constructor para los objetos de la clase Circulo
     */
    public Circulo(int queRadio){
        radio = queRadio;
        centro = new Punto(0, 0);
    }
    /**
     * constructor para los objetos de la clase Circulo
     */
    public Circulo(int queRadio, Punto queCentro){
       radio = queRadio;
       centro = queCentro;
    }
    /**
     * 
     * @return devuelve el radio del c�rculo    
     */
    public double getRadio(){
        return radio;
    }

    public Punto getCentro(){
        return centro;
    }
      /**
     * 
     * @param   El nuevo valor del radio
     */
    public void setRadio(int nuevoRadio){
        radio = nuevoRadio;
    }

    public void setCentroX(int nuevoX){
        centro.setX(nuevoX);
    }

    public void setCentroY(int nuevoY){
        centro.setY(nuevoY);
    }
    /*
     * @return devuelve el �rea del c�rculo
     */
    public double calcularArea(){
        return 2 * PI * radio * radio;
    }
    /*
     * @return devuelve el per�metro del c�rculo
     */
    public double calcularPerimetro(){
        return 2 * PI * radio;
    }
    @Override
    public String toString(){
        return "Radio = "+radio+"\nCentro: "+centro.toString()+"\n";
    }

    public void printCirculo(){
        System.out.println(this);
    }
}