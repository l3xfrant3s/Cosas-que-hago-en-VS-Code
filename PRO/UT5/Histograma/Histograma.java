package PRO.UT5.Histograma;

public class Histograma{
    private final int MAX = 6;
    private int[] valores;

    public Histograma(){
        inicializar();
    }

    private int generarAleatorio(){
        return (int)(Math.random() * 46) + 5;
    }

    private void inicializar(){
        valores = new int[MAX];
        System.out.print("[");
        for (int i = 0; i < MAX; i++){
            valores[i] = generarAleatorio();
            System.out.print(valores[i]+(i+1<MAX?", ":"]\n"));
        }
    }

    public void escribirHistograma(){
        for (int i = 0; i < MAX; i++){
            for (int j = 0; j < valores[i]; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}