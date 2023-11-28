package PRO.UT4.Cuadrado;

public class Cuadrado {
    private final char ASTERISCO = '*';
    private final char ESPACIO = ' ';
    private final char ASPA = 'X';
    private int lado;
    public Cuadrado(int cuanto){
        lado = cuanto<1?1:cuanto;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    private String dibujarASTERISCO(){return ASTERISCO+" ";}
    private String dibujarESPACIO(){return ESPACIO+" ";}
    private String dibujarASPA(){return ASPA+" ";}


    private String dibujarLinea(){
        String linea = "";
        for(int i = 0; i < lado; i++){linea += dibujarASTERISCO();}
        return linea;
    }

    private String dibujarDos(int posPrimero){
        String linea = "";
        for(int i = 0; i < lado; i++){
            if(i == posPrimero || i == (lado-1-posPrimero)) linea += dibujarASTERISCO();
            else linea += dibujarESPACIO();
        }
        return linea;
    }

    private String dibujarBicolor(int ultimoAst){
        String linea = "";
        for(int i = 0; i < lado; i++){
            if(i > ultimoAst) linea += dibujarASPA();
            else linea += dibujarASTERISCO();
        }
        return linea;
    }

    public void dibujarBicolor(){
        for (int i = 0; i < lado; i++) System.out.println(dibujarBicolor(i));
    }

    public void dibujarContorno(){
        for (int i = 0; i < lado; i++){
            if(i == 0 || i == lado-1)System.out.println(dibujarLinea());
            else System.out.println(dibujarDos(0));
        }
    }

    public void dibujarEnAspa(){
        for (int i = 0; i < lado; i++) System.out.println(dibujarDos(i));
    }
}
