
/**
 * LA clase modela un punto 
 * 
 * @author (su nombre) 
 * @version (n� versi�n o fecha)
 */
public class Punto{
    // variables de instancia
    private int x;
    private int y;

    /**
     * Constructor de la clase Punto
     */
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Accesor par el atributo x
     * @return  El valor de la coordenada x   
     */
    public int getX(){   
        return x;
    }
    
    /**
     * Accesor para el atributo y
     * @return  El valor de la coordenada y   
     */
    public int getY(){   
        return y;
    }
    
    /**
      * 
      *  Mutador para la coordenada x
      * @param x es el nuevo valor de x
      * @return     
      */
    public void setX(int x){
        this.x = x;        
    }
 
     /**
     * Mutador para la coordenada y
     * @param  y es el nuevo de y  
     */
    public void setY(int y){
       this.y = y;        
    }
     
     /**
      * @return  Devuelve una cadena con la representaci�n del 
      *          punto
      */
    public String toString(){
        String str = "";
        str = str + "Valor de x = " + x  + "\n"
                    + "Valor de y = " + y + "\n";
        return str;      
    }
}