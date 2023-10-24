package PRO.Cafetera;

public class Cafetera {
    private int capacidadMaxima, cantidadActual;
    public Cafetera(){
        capacidadMaxima = 1000;
        cantidadActual = 0;
    }

    public void setCapacidadMaxima(int nuevoMaximo){
        if(nuevoMaximo > 0){
            capacidadMaxima = nuevoMaximo;
            if(cantidadActual > capacidadMaxima) llenarCafetera();
        }
    }
    
    public void setCantidadActual(int nuevoActual){
        if(nuevoActual <= capacidadMaxima){
            cantidadActual = nuevoActual;
        }
    }

    public int getCapacidadMaxima(){return capacidadMaxima;}

    public int getCantidadActual(){return cantidadActual;}

    public void llenarCafetera(){cantidadActual = capacidadMaxima;}

    public void servirTaza(int capacidadTaza){
        if(capacidadTaza > 0){
            if(capacidadTaza > cantidadActual) vaciarCafetera();
            else cantidadActual -= capacidadTaza;
        }
    }

    public void vaciarCafetera(){cantidadActual = 0;}

    public void agregarCafe(int cafeDeMas){
        if(cantidadActual + cafeDeMas > capacidadMaxima)llenarCafetera();
        else cantidadActual += cafeDeMas;
    }
}