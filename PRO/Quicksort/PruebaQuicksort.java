package PRO.Quicksort;

public class PruebaQuicksort {
    public static void main(String[] args) {
        int[] lista = new int[100];
        //int[] lista = {89,16,29,21};
        String listaDes = "{";
        for(int i = 0; i < lista.length; i++){
            lista[i] = (int) (Math.random() * 1000) + 1;
            listaDes+=lista[i]+(i==lista.length-1?"}":",");
        }
        System.out.println("Vamos a ordenar la lista "+listaDes);
        int[] listaOr = Quicksort.ordenarQuickSort(lista);
        String listaOrd = "{";
        for(int i = 0; i < listaOr.length; i++){
            listaOrd+=listaOr[i]+(i==listaOr.length-1?"}":",");
        }
        System.out.println("La lista resultate "+listaOrd+" tiene "+listaOr.length+" elementos y "+(Quicksort.estaOrdenado(listaOr)?"":"no ")+"está ordenada.");
    }
}
