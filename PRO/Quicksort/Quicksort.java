package PRO.Quicksort;

import java.util.Arrays;
public class Quicksort {
    static long iter = 0;
    public static int[] ordenarQuickSort(int[] aOrdenar){
        //iter++;
        //if(iter%1000==0)SOP(iter+"\n");

        if(aOrdenar.length == 0 || aOrdenar.length == 1)return aOrdenar;
        int pivote = aOrdenar[0];
        //Buscar una forma mejor de escoger pivote
        int[] mayores = new int[aOrdenar.length];
        int[] menores = new int[aOrdenar.length];
        int cuentaMayores = 0;
        int cuentaMenores = 0;
        for(int i = 1; i < aOrdenar.length; i++){
            if(aOrdenar[i] <= pivote) {
                menores[cuentaMenores] = aOrdenar[i];
                cuentaMenores++;
                //SOP("Menor!\n");
            }
            else{
                mayores[cuentaMayores] = aOrdenar[i];
                cuentaMayores++;
                //SOP("Mayor!\n");
            }
        }
        /*for(int i = 0; i < mayores.length; i++){
            SOP(mayores[i]+",");
        }
        SOP("\n");
        for(int i = 0; i < menores.length; i++){
            SOP(menores[i]+",");
        }
        SOP("\n");
        SOP("La lista de menores tiene "+cuentaMenores+" elementos.\nLa lista de mayores tiene "+cuentaMayores+" elementos.\n");*/
        int[] mayoresTruncado = Arrays.copyOf(mayores, cuentaMayores);
        /*for(int i = 0; i < mayoresTruncado.length; i++){
            SOP(mayoresTruncado[i]+",");
        }
        SOP("\n");*/
        System.arraycopy(ordenarQuickSort(mayoresTruncado), 0, mayoresTruncado, 0, cuentaMayores);
        int[] menoresTruncado = Arrays.copyOf(menores, cuentaMenores);
        /*for(int i = 0; i < menoresTruncado.length; i++){
            SOP(menoresTruncado[i]+",");
        }
        SOP("\n");*/
        System.arraycopy(ordenarQuickSort(menoresTruncado), 0, menoresTruncado, 0, cuentaMenores);
        int[] ordenado = Arrays.copyOf(menoresTruncado, aOrdenar.length);
        /*for(int i = 0; i < ordenado.length; i++){
            SOP(ordenado[i]+",");
        }
        SOP("\n");*/
        ordenado[cuentaMenores] = pivote;
        /*for(int i = 0; i < ordenado.length; i++){
            SOP(ordenado[i]+",");
        }
        SOP("\n");*/
        System.arraycopy(mayoresTruncado, 0, ordenado, cuentaMenores+1, cuentaMayores);
        /*for(int i = 0; i < ordenado.length; i++){
            SOP(ordenado[i]+",");
        }
        SOP("\n");*/
        return ordenado;
    }
    public static void SOP(String aImprimir){
        System.out.print(aImprimir);
    }

    public static boolean estaOrdenado(int[] lista){
        SOP("Dentro\n");
        for(int i=0; i<lista.length-1;i++){
            if(lista[i]>lista[i+1])return false;
        }
        SOP("Fuera\n");
        return true;
    }
}