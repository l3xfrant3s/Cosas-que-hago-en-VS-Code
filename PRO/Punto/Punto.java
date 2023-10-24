public class Punto{
    private int x;
    private int y;
    private int z;
    
    /*public Punto(){ //constructor por nulo
    }*/
    public Punto(){ //constructor por defecto
        x = 1;
        y = 1;
        z = 1;
    }
    
    public Punto(int queX, int queY, int queZ){ //constructor de inicialización
        x = queX;
        y = queY;
        z = queZ;
    }
    
    public Punto(Punto otro){ //constructor de copia
        x = otro.getX();
        y = otro.getY();
        z = otro.getZ();
    }
    
    public Punto(int que){ // constructor de conversion
        x = que;
        y = que;
        z = que;
    }
    
    public void setX(int queX){
        this.x = queX;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int queY){
        this.y = queY;
    }
    
    public int getY(){
        return y;
    }
    
    public void setZ(int queZ){
        this.z = queZ;
    }
    
    public int getZ(){
        return z;
    }
    
    @Override
    public String toString(){
        return "("+ x + ", " + y + ", " + z + ")";
    }
}