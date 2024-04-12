package examen_ut7_afr;

public abstract class Zapato implements Comparable<Zapato>{
    protected String codigo, color, marca;
    protected int talla;
    protected double precio;
    protected char sexo;
    protected boolean vendido;
    
    protected Zapato(String color, String marca, int talla, double precio, char sexo){
        this.color = color;
        this.marca = marca;
        this.talla = talla > 20 ? talla : 39;
        this.precio = precio > 0 ? precio : 19.99;
        String elSexo = String.valueOf(sexo).toUpperCase();
        this.sexo = elSexo.equals("H") || elSexo.equals("M") ? elSexo.charAt(0) : 'H';
        generarCodigo();
        this.vendido = false;
    }
    
    private void generarCodigo(){
        this.codigo = marca.substring(0, 2)+(marca+color+talla).hashCode()+talla+sexo+(vendido?"V":"");
    }
    
    public String vender(){
        this.vendido = true;
        generarCodigo();
        return this.getCodigo();
    }
    
    public String getCodigo() {
        return codigo;
    }
    public String getColor() {
        return color;
    }
    public String getMarca() {
        return marca;
    }
    public int getTalla() {
        return talla;
    }
    public double getPrecio() {
        return precio;
    }
    public char getSexo() {
        return sexo;
    }
    public boolean getVendido(){
        return vendido;
    }

    public void setColor(String color) {
        this.color = color;
        generarCodigo();
    }
    public void setMarca(String marca) {
        this.marca = marca;
        generarCodigo();
    }
    public void setTalla(int talla) {
        this.talla = talla;
        generarCodigo();
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
        generarCodigo();
    }
    
    public boolean equals(Zapato o){
        if(!(o instanceof Zapato)){
            return false;
        }
        return this.getCodigo().equals(o.getCodigo());
    }
    
    public int compareTo(Zapato o){
        return this.getCodigo().compareTo(o.getCodigo());
    }
}