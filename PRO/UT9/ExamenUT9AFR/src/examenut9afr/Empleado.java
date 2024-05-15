package examenut9afr;

import java.io.Serializable;

/**
 *
 * @author l3xfrant3s
 */
public class Empleado implements Serializable{
    private String DNI, nombre, cargo;
    private int edad;
    private double sueldo;
    
    private void DNIhandler() throws DNIIncorrectoException{
        try{
            if(DNI.length() != 9 || !Character.isLetter(DNI.charAt(8))){
                throw new DNIIncorrectoException(DNI, nombre);
            }
        } catch(StringIndexOutOfBoundsException S){
            throw new DNIIncorrectoException(DNI, nombre);
        }
    }
    
    public Empleado(String d, String n, int e, String c, double s) throws DNIIncorrectoException{
        DNI = d;
        nombre = n;
        edad = e;
        cargo = c;
        sueldo = s;
        try{
            DNIhandler();
        } catch(DNIIncorrectoException i) {
            System.out.print("");
        }
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}