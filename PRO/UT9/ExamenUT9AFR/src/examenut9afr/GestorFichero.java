package examenut9afr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author l3xfrant3s
 */
public class GestorFichero {
    
    public static void escribirObjetos(String fichero, Object obj){
        try{
            ObjectOutputStream fout=new ObjectOutputStream(new FileOutputStream(fichero));
            fout.writeObject(obj);
            fout.close();
        }
        catch(IOException e){ System.out.println("Error Escribir");}
    }
    public static void escribirTexto(String fichero, String aEscribir){
        try{
            FileWriter escritor=new FileWriter(fichero, true);
            escritor.write(aEscribir);
            escritor.close();
        }
        catch(IOException e){ System.out.println("Error Escribir");}
    }
    /*public static void escribirTexto(BufferedWriter escritor, String aEscribir){
        try{
            escritor.write(aEscribir);
            escritor.close();
        }
        catch(IOException e){ System.out.println("Error Escribir");}
    }*/
    public static void verErrores(){
        try{
            BufferedReader lectorErrores=new BufferedReader(new FileReader("errores.txt"));
            int cuentaErrores = 0;
            while(lectorErrores.ready()){
                System.out.println(lectorErrores.readLine());
                cuentaErrores++;
            }
            System.out.println("En total han habido " + cuentaErrores + " errores");
            lectorErrores.close();
        }
        catch(IOException e){
            System.out.println("No deberías estar aquí");
        }
    }
    /*public static void mostrarNuevoFichero(String fichero){
        try{
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream(fichero));
            while(fin.available() > 0){
                System.out.println(fin.);
                cuentaErrores++;
            }
            System.out.println("En total han habido " + cuentaErrores + " errores");
            lectorErrores.close();
        }
        catch(IOException e){
            System.out.println("No deberías estar aquí");
        }
    }*/
    
    /*public void leerObjetos(String fichero) throws FileNotFoundException, IOException{
        ObjectInputStream fin=new ObjectInputStream(new FileInputStream(fichero));
        try{
            fin.close();
        }
        catch(Exception i){System.out.println("Error Leer");}
    }*/
}
