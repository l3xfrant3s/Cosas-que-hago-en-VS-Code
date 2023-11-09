package PRO.Quicksort;

import java.time.Instant;

public class PruebaQuicksort {
    public static void main(String[] args) {
        int[] lista = new int[200000];
        //int[] lista = {916,1296,55,1588};
        //String listaDes = "{";
        for(int i = 0; i < lista.length; i++){
            lista[i] = (int) (Math.random() * 2000) + 1;
            //listaDes+=lista[i]+(i==lista.length-1?"}":",");
        }
        //System.out.println("Vamos a ordenar la lista "+listaDes);
        System.out.println("Dentro");
        Instant tiempo = Instant.now();
        int[] listaOr = Quicksort.ordenarQuickSort(lista, lista.length);
        Instant tiempo2 = Instant.now();
        System.out.println("Fuera: "+(tiempo2.toEpochMilli()-tiempo.toEpochMilli())+" milisegundos");
        //System.out.println(Quicksort.cuenta0a2);
        System.out.println("La lista "+(Quicksort.estaOrdenado(listaOr)?"":"no ")+"está ordenada");
        /*String listaOrd = "{";
        for(int i = 0; i < listaOr.length; i++){
            listaOrd+=listaOr[i]+(i==listaOr.length-1?"}":",");
        }
        System.out.println("La lista resultate "+listaOrd+" tiene "+listaOr.length+" elementos y "+(Quicksort.estaOrdenado(listaOr)?"":"no ")+"está ordenada.");*/
    }
}