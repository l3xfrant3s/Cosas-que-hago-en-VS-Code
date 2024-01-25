package PRO.UT5.Bingo;

public class CartonBingo {
    private final int FILAS = 3;
    private final int COLUMNAS = 5;
    private int[][] carton;

    public CartonBingo(){
        generarNuevoCarton();
    }

    public boolean esBingo(){
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                if(carton[i][j] != 0)return false;
            }
        }
        return true;
    }

    public boolean esLinea(int laFila){
        for(int i = 0; i < COLUMNAS; i++){
            if(carton[laFila][i] != 0)return false;
        }
        return true;
    }

    public void escribirCarton(){}

    private boolean estaNumero(int numero){
        return obtenerPosicionNumero(numero) != null;
    }

    public void generarNuevoCarton(){
        carton = new int[FILAS][COLUMNAS];
        int aleatorio = 0;
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                while(true){
                    if(!estaNumero(aleatorio = (int)(Math.random()*80) + 1)){
                        carton[i][j] = aleatorio;
                        break;
                    }
                }
            }
        }
    }

    private Posicion obtenerPosicionNumero(int numero){
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                if(carton[i][j] == numero) return new Posicion(i, j);
            }
        }
        return null;
    }

    public void tacharNumero(int numero){
        Posicion dondeNumero;
        if((dondeNumero = obtenerPosicionNumero(numero)) != null){
            carton[dondeNumero.getFila()][dondeNumero.getCol()] = 0;
        }
    }

    public String toString(){
        String aDevolver = "Cartón generado\n";
        for(int i = 0; i < FILAS; i++){
            for(int j = 0; j < COLUMNAS; j++){
                aDevolver += carton[i][j] + (j+1==COLUMNAS?"\n":" ");
            }
        }
        return aDevolver;
    }
}