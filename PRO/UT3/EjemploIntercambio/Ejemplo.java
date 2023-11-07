package PRO.UT3.EjemploIntercambio;
public class Ejemplo{
    private int a, b;
    
    /**Constructor de inicialización, requiere dos números enteros cualquiera
     * @param primerA valor inicial del atributo a
     * @param primerB valor inicial del atributo b
     */
    public Ejemplo(int primerA, int primerB){
        a = primerA;
        b = primerB;
    }
    
    /**Hace que el valor de a sea igual al de b y viceversa, 
     * para ello crea una variable temporal del mismo nombre
     */
    
    public void intercambiar(){
        int temporal = b;
        b = a;
        a = temporal;
    }
    
    /**Imprime en pantalla los valores de los atributos a y b en el siguiente formato:
     * 
     * Atributo a = X
     * Atributo b = X
     */
    public void escribir(){     
        System.out.println("Atributo a = " + a + "\nAtributo b = " + b);
    }

    /**Imprime en pantalla la frase "Antes del intercambio" con un salto de línea
     */
    public void promptAntes(){
        System.out.println("Antes del intercambio:");
    }
    
    /**Imprime en pantalla la frase "Después del intercambio" con un salto de línea
     */
    public void promptDespues(){
        System.out.println("Después del intercambio:");
    }
}
