/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenut9afr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author l3xfrant3s
 */
public class ExamenUT9AFR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader empleados = new BufferedReader(new FileReader("empleados.txt"));
            while(empleados.ready()){
                String[] empleado = empleados.readLine().split(",");
                Empleado elEmpleado = new Empleado(empleado[0], empleado[1], Integer.valueOf(empleado[2]), empleado[3], Integer.valueOf(empleado[4]));
                if(elEmpleado.getCargo().equals("Administrativo"))elEmpleado.setSueldo(elEmpleado.getSueldo()*1.1);
                if(elEmpleado.getCargo().equals("Informatico"))elEmpleado.setSueldo(elEmpleado.getSueldo()*1.15);
                /*try{}
                catch(StringIndexOutOfBoundsException S){System.out.println(false);}
                System.out.println(Character.isLetter(elEmpleado.getDNI().charAt(8)));*/
                GestorFichero.verErrores();
                GestorFichero.escribirObjetos("binario.txt", elEmpleado);
            }
            GestorFichero.verErrores();
            empleados.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Este fichero no existe");
        } catch (IOException ex) {
            System.out.println("Error de entrada o salida");
        }
        
        
            
            /*try{
            Empleado socorro = new Empleado("12345678", "ksahvdkj", 2, "kjasfdsd", 3);
            }
            catch(IOException e){
            System.out.println("Uh oh");
            }
            catch(DNIIncorrectoException e){
            System.out.println("Uh oh");
            }*/
        
    }
}