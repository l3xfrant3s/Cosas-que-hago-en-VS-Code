public class Socio{

    private String nombre, identificador;
    private int numSocio, tipo;
    private final int NUMERARIO = 10;
    private final int NO_NUMERARIO = 20;
    private final int FAMILIAR = 30;
    private static int nuevoCodSocio = 1;
    
    
    public Socio(int elTipo, String DNI, String comoTeLlamas, String primerApellido){
        if(elTipo == NUMERARIO || elTipo == NO_NUMERARIO || elTipo == FAMILIAR)tipo = elTipo;
        else tipo = NO_NUMERARIO;
        asignarNombre(comoTeLlamas, primerApellido);
        identificador = DNI;
        numSocio = nuevoCodSocio;
        nuevoCodSocio++;
    }
    
    private void asignarNombre(String nombreSocio, String apellido){
        nombre = apellido + ", " + nombreSocio;
    }
    
    public int getTipoSocio(){
        return tipo;
    }
    
    public void setTipoSocio(int t){
        if(t == NUMERARIO || t == NO_NUMERARIO || t == FAMILIAR)tipo = t;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        String tipoString = "";
        switch(tipo){
            case 10:tipoString="NUMERARIO";break;
            case 20:tipoString="NO_NUMERARIO";break;
            case 30:tipoString="FAMILIAR";break;
        }
        return "Nombre: "+nombre+"\nTipo: "+tipoString+"\nNúmero de socio: "+numSocio+"\nDNI: "+identificador;
    }
}
