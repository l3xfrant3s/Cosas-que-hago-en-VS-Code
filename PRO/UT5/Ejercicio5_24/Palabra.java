package PRO.UT5.Ejercicio5_24;

public class Palabra {
    private String palabra;
	
	public Palabra(String palabra){
		this.palabra = palabra;
	}
    public String invertir(){
        String invertida = "";
        for(int i = palabra.length(); i >= 0; i--){
            invertida += palabra.charAt(i);
        }
        return invertida;
    }

    public int contarVocales(){
        int cuentaVocales = 0;
        String palabraMinus = palabra.toLowerCase();
        for (int i = 0; i < palabra.length(); i++){
            switch(palabraMinus.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': cuentaVocales++;
            }
        }
        return cuentaVocales;
    }

    public boolean mayorQue(String palabra){
        return this.palabra.equals(palabra);
    }

    /*public boolean esPalindromo(){}*/
}
