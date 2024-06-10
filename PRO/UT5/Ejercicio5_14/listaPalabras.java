package PRO.UT5.Ejercicio5_14;

public class listaPalabras {
    private Palabra[] diccionario;
    private final int MAX_PALABRAS = 10;
    private int pos;

    public listaPalabras(int numPalabras){
        diccionario = new Palabra[numPalabras > MAX_PALABRAS?MAX_PALABRAS:numPalabras];
        pos = 0;
    }

    public void insertarPalabra(Palabra aInsertar){
        if(pos < diccionario.length){
            diccionario[pos++] = aInsertar;
        }
    }

    public Palabra obtenerPalabra(int posicion){
        if(posicion < 0 || posicion >= pos){
            return null;
        }
        return diccionario[posicion];
    }

    public void escribirDiccionario(){
        for(int i = 0; i < pos; i++){
            System.out.println(diccionario[i]);
        }
    }
}
