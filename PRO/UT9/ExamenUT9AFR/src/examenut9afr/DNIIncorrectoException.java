/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenut9afr;

/**
 *
 * @author l3xfrant3s
 */
public class DNIIncorrectoException extends IllegalArgumentException{
    //private String DNIErroneo, NombreErroneo;
    public DNIIncorrectoException(String DNIErroneo, String NombreErroneo){
        //this.DNIErroneo = DNIErroneo;
        //this.NombreErroneo = NombreErroneo;
        String erronea = DNIErroneo + "@" + NombreErroneo + "\n";
        GestorFichero.escribirTexto("errores.txt", erronea);
    }
}