package PRO.UT5.Matriz;



public class Matriz {
    private int[][] elementos;
    private int filas, columnas;

    private void errorDeParametro(){throw new IllegalArgumentException("Error en parámetro");}
    private boolean comprobarIndices(int f){return f > 0;}
    private boolean comprobarIndices(int f, int c){return f > 0 && c > 0;}

    public Matriz(int filas){
        if(comprobarIndices(filas)){
            this.filas = filas;
            this.columnas = filas;
            inicializar();
        } else errorDeParametro();
    }

    public Matriz(int filas, int columnas){
        if(comprobarIndices(filas, columnas)){
            this.filas = filas;
            this.columnas = columnas;
            inicializar();
        } else errorDeParametro();
    }

    public Matriz(int[][] m){
        if(verificar(m)){
            filas = m.length;
            columnas = m[0].length;
            System.arraycopy(m, 0, elementos, 0, filas);
        } else errorDeParametro();
    }

    private void inicializar(){
        elementos = new int[filas][columnas];
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                elementos[i][j] = (int)(Math.random()*20) + 1;
            }
        }
    }

    private boolean verificar(int[][] m){
        if(m == null || m.length <= 0){
            return false;
        } else {
            for (int i = 0; i < m.length-1; i++){
                if(m[i].length <= 0 || m[i].length != m[i+1].length){
                    return false;
                }
            }
            return true;
        }
    }

    public int getValor(int fila, int col){
        if(comprobarIndices(fila, col)){
            return elementos[fila][col];
        }
        else {
            errorDeParametro();
            return -1;
        }
    }

    public int getNumFilas() {
        return filas;
    }

    public int getNumColumnas() {
        return columnas;
    }

    public void setValor(int valor, int fila, int col){
        if(comprobarIndices(fila, col)){
            elementos[fila][col] = valor;
        }
    }

    /*public Matriz sumar(Matriz otra){
        Matriz suma = new Matriz();
    }

    public Matriz restar(Matriz otra){}

    public Matriz multiplicarPor(int factor){}

    public Matriz multiplicarPor(Matriz otra){}

    public Matriz traspuesta(){}

    public String toString(){}*/

}