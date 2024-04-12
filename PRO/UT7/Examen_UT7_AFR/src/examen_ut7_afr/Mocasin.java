package examen_ut7_afr;

public class Mocasin extends Zapato{
    
    private String tejido;
    
    public Mocasin(String color, String marca, int talla, double precio, char sexo, String tejido){
        super(color, marca, talla, precio, sexo);
        this.tejido = tejido;
    }
    
    private void generarCodigo(){
        this.codigo = marca.substring(0, 1)+(marca+color+talla+tejido).hashCode()+talla+sexo+(vendido?"VM":"");
    }
    
    public String getTejido() {
        return tejido;
    }
    public void setTejido(String tejido) {
        this.tejido = tejido;
        generarCodigo();
    }
    
    @Override
    public String toString(){
        return this.getMarca() + " de " + this.getTejido() + " de color " +
            this.getColor() + ", numero " + this.getTalla() + " para " +
            (this.getSexo() == 'H'?"hombre: ":"mujer: ") +this.getPrecio() + "€.";
    }
}
