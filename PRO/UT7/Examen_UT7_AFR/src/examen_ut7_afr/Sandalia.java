package examen_ut7_afr;

public class Sandalia extends Zapato{
    private int tiras;
    private boolean cerrada;
    
    public Sandalia(String color, String marca, int talla, double precio, char sexo, int tiras, boolean esCerrada){
        super(color, marca, talla, precio, sexo);
        this.tiras = tiras;
        this.cerrada = esCerrada;
    }
    
    private void generarCodigo(){
        this.codigo = marca.substring(0, 2)+(marca+color+talla+tiras+cerrada).hashCode()+talla+sexo+(vendido?"VS":"");
    }

    public int getTiras() {
        return tiras;
    }
    public boolean isCerrada() {
        return cerrada;
    }

    public void setTiras(int tiras) {
        this.tiras = tiras;
        generarCodigo();
    }
    public void setEsCerrada(boolean esCerrada) {
        this.cerrada = esCerrada;
        generarCodigo();
    }
    
    @Override
    public String toString(){
    return this.getMarca() + " con " + this.getTiras() + " tiras " + 
        (this.isCerrada()?" cerrada":" abierta")+ " de color " +
        this.getColor() + " y numero " + this.getTalla() + " para " +
        (this.getSexo() == 'H'?"hombre: ":"mujer: ") +this.getPrecio() + "€.";
    }
}
