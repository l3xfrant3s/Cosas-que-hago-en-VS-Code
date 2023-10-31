public class Pelicula{
    private String nombre, director;
    private int genero, duracion, anioEstreno;
    private double calificacion;
    private final int ACCION = 1;
    private final int COMEDIA = 2;
    private final int DRAMA = 3;
    private final int FANTASIA = 4;
    private final int SUSPENSE = 5;
    public Pelicula(String elNombre, String elDirector, int laDuracion, int elGenero){
        nombre = elNombre;
        director = elDirector;
        duracion = laDuracion>0?laDuracion:1;
        genero = elGenero>=1?(elGenero<=5?elGenero:ACCION):ACCION;//Si el género introducido es mayor o igual que 1 y es menor o igual que 5, entonces se asigna al valor género del objeto, si no se asigna ACCION o 1
        /*genero = elGenero;
        if(elGenero < 1 || elGenero > 5) genero = ACCION;*/
        anioEstreno = 2023;
        calificacion = 0.0;
    }
    
    public String getNombre(){return nombre;}
    public String getDirector(){return director;}
    public int getGenero(){return genero;}
    public int getDuracion(){return duracion;}
    public int getAnioEstreno(){return anioEstreno;}
    public double getCalificacion(){return calificacion;}
    
    public void setNombre(String elNombre){nombre = elNombre;}
    public void setDirector(String elDirector){director = elDirector;}
    public void setGenero(int elGenero){
        if(elGenero >= 1 && elGenero <= 5){
            genero = elGenero;
        }
    }
    public void setDuracion(int laDuracion){if (laDuracion > 0)duracion = laDuracion;}
    public void setAnioEstreno(int elAnioEstreno){
        if (elAnioEstreno >= 1900 && elAnioEstreno <= 2023)anioEstreno = elAnioEstreno;
    }
    public void setCalificacion(double laCalificacion){
        if(laCalificacion <= 10 && laCalificacion >= 0)calificacion = laCalificacion;
        
    }
    
    public boolean esBuenaPeli(){return calificacion >= 8 && calificacion <= 10;}
    
    public double getValorPeli(){
        int puntuacion = 4500;
        if(anioEstreno < 2023){
            puntuacion = 3000;
            if(anioEstreno < 2018){
                puntuacion = 2000;
                if(anioEstreno < 2013)puntuacion = 1500;
            }
        }
        return puntuacion * calificacion;
    }
    
    public String generoToString(){
        switch(genero){
            case 1: return "Acción";
            case 2: return "Comedia";
            case 3: return "Drama";
            case 4: return "Fantasía";
            case 5: return "Suspense";
            default: return "";
        }
    }
    
    public String toString(){
        return "Título: "+nombre+"\nDirector: "+director+"\nAño de estreno: "+anioEstreno+"\nDuración: "+
        duracion+" minuto"+(duracion==1?"":"s")+"\nGénero: "+generoToString()+"\nCalificación: "+calificacion;
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
}
