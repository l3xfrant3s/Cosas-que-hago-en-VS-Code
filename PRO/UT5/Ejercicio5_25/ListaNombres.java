package PRO.UT5.Ejercicio5_25;

public class ListaNombres {
    private final int MAX_NOMBRES = 10;
    private String[] nombres;
    private int posicionUltimo;


    public ListaNombres(){
        nombres = new String[MAX_NOMBRES];
        posicionUltimo = -1;
    }

    private boolean estaNombre(String nombre){
        for(int i = 0; i < posicionUltimo; i++){
            if(nombres[i].compareTo(nombre) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean insertarNombres(String nombre){
        
        if(!estaNombre(nombre) && posicionUltimo < 9){
            int puntoDeInsercion = -1;
            while(nombre.compareTo(nombres[++puntoDeInsercion]) > 0){
                continue;
            }
            String temporal = "";
        }
        //puntoDeInsercion es la posicion del nombre que quedará después del que vamos a insertar
        return false;
    }

    public String nombreMasLargo(){
        int indiceMasLargo = -1;
        if(posicionUltimo > -1){
            for(int i = 0; i <= posicionUltimo; i++){
                if (nombres[i].length() > indiceMasLargo){
                    indiceMasLargo = i;
                }
            }
            return nombres[indiceMasLargo];
        }
        return null;
    }

    /*public borrarLetra(){

    }

    public empiezanPorLetra(){

    }

    public empiezanPor(){

    }

    public listaVacia(){

    }

    public listaLlena(){

    }

    public toString(){

    }*/
}
