package examen_ut7_afr;

public class Deportiva extends Zapato{
    private String descripcion;
    private boolean impermeable;
    
    public Deportiva(String color, String marca, int talla, double precio, char sexo, String descripcion, boolean esImpermeable){
        super(color, marca, talla, precio, sexo);
        this.descripcion = descripcion;
        this.impermeable = esImpermeable;
    }
    
    private void generarCodigo(){
        this.codigo = marca.substring(0, 2)+(marca+color+talla+descripcion+impermeable).hashCode()+talla+sexo+(vendido?"VD":"");
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public boolean isImpermeable() {
        return impermeable;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        generarCodigo();
    }
    public void setEsImpermeable(boolean esImpermeable) {
        this.impermeable = esImpermeable;
        generarCodigo();
    }
    
    @Override
    public String toString(){
        return this.getMarca() + this.getDescripcion() + " de color " +
            this.getColor() + ", numero " + this.getTalla() +
            (this.isImpermeable()?" ":" no") + " impermeable" + " para " +
            (this.getSexo() == 'H'?"hombre: ":"mujer: ") +this.getPrecio() + "€.";
    }
}