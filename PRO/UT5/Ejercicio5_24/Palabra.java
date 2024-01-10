package PRO.UT5.Ejercicio5_24;

public class Palabra {
    private String palabra;
	
	public Palabra(String palabra){
		this.palabra = palabra;
	}
    public String invertir(){
        String invertida = "";
        for(int i = palabra.length(); i > 0; i--){
            invertida += palabra.charAt(i);
        }
        return invertida;
    }

    public int contarVocales(){
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < palabra.length(); i++){
            
        }
    }

    public boolean mayorQue(String palabra){}

    public boolean esPalindromo(){}
}
