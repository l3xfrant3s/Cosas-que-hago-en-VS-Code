package PRO.UT7.ejercicio3;

public class FicheroMusica extends Fichero{
    private int duracion;

    public FicheroMusica(String titulo, int tamanio, int duracion){
        super(titulo, tamanio);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}