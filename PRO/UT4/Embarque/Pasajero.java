package PRO.UT4.Embarque;

public class Pasajero {
    private String nombre;
    private int edad;

    //public Pasajero(){};

    public Pasajero(String queNombre){
        nombre = queNombre;
        edad = -1;
    }

    public Pasajero(String queNombre, int cuantosAños){
        nombre = queNombre;
        edad = cuantosAños>-1?cuantosAños:-1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void printDetalles(){
        System.out.println("Nombre: "+nombre+"\nEdad: "
        +(edad<0?"Sin especificar":edad));
    }

    public boolean esMasJovenQue(Pasajero otroPasajero){
        if(otroPasajero != null && this.getEdad() > -1 && otroPasajero.getEdad() > -1){
            return this.getEdad() < otroPasajero.getEdad();
        }
        return false;
    }
}
