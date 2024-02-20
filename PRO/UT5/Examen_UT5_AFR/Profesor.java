package PRO.UT5.Examen_UT5_AFR;

public class Profesor{

    private static int nuevoID = 1;
    private String nombre;
    private int edad;
    private int numeroIdentificativo;
    private Cargo cargo;

    public Profesor(String nombre, int edad, Cargo cargo){
        this.nombre = nombre;
        this.edad = edad;
        this.cargo = cargo;
        this.numeroIdentificativo = nuevoID++;
    }

    public Profesor(String nombre_y_edad) throws NumberFormatException{
        int posDosPuntos = nombre_y_edad.indexOf(":");
        /*System.out.println(posDosPuntos);
        System.out.println(nombre_y_edad.substring(posDosPuntos+1));
        int temp = Integer.parseInt(nombre_y_edad.substring(posDosPuntos+1));
        System.out.println(temp);

        /*for(int i = 0; i < nombre_y_edad.length(); i++){
            if(nombre_y_edad.charAt(i) == ':'){
                posDosPuntos = i;
                break;
            }
        }*/
        try{
            this.edad = Integer.parseInt(nombre_y_edad.substring(posDosPuntos+1));
        } catch (Exception e){
            System.err.println("La edad introducida no esta en un formato adecuado");
            this.edad = 0;
        }
        this.nombre = nombre_y_edad.substring(0, posDosPuntos);
        this.numeroIdentificativo = nuevoID++;
        this.cargo = Cargo.DOCENTE;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return numeroIdentificativo;
    }

    public String toString(){
        return "\nNombre: " + nombre + " (Edad: " + edad + ")\nNumero Identificativo: " +
        + numeroIdentificativo + "\nPuesto: " + cargo.toString();
    }
}