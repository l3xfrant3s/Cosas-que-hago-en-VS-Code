package PRO.Quicksort;

import java.util.Arrays;
public class Quicksort {
    //static long cuenta0a2 = 0;
    //static String paso = "inicial";
    public static int[] ordenarQuickSort(int[] aOrdenar, int limite){
        //SOP("Entra en "+paso+"\n");
        if(limite < 3){
            //cuenta0a2++;
            //SOP("Vector con menos de 3 valores\n");
            switch(limite){
                case 0:
                //case 1: imprimirArray(aOrdenar, limite);return aOrdenar;
                case 1: return aOrdenar;
                //case 2: imprimirArray(aOrdenar, limite);return (aOrdenar[0]>aOrdenar[1]?new int[] {aOrdenar[1],aOrdenar[0]}:aOrdenar);
                case 2: return (aOrdenar[0]>aOrdenar[1]?new int[] {aOrdenar[1],aOrdenar[0]}:aOrdenar);
                //case 3: return (aOrdenar[0]>aOrdenar[1]?new int[] {aOrdenar[1],aOrdenar[0]}:aOrdenar);
            }
            //if(aOrdenar.length == 0 || aOrdenar.length == 1){}
            //else if(aOrdenar.length == 2){cuenta0a2++; return (aOrdenar[0]>aOrdenar[1]?new int[] {aOrdenar[1],aOrdenar[0]}:aOrdenar);}
        }
        int pivote = aOrdenar[0];
        //Buscar una forma mejor de escoger pivote
        int[] menores = new int[limite];
        int[] mayores = new int[limite];
        int cuentaMenores = 0;
        int cuentaMayores = 0;
        for(int i = 1; i < limite; i++){
            if(aOrdenar[i] <= pivote) {
                menores[cuentaMenores] = aOrdenar[i];
                //SOP("menor "+cuentaMenores+": "+menores[cuentaMenores]+"\n");
                cuentaMenores++;
            }
            else{
                mayores[cuentaMayores] = aOrdenar[i];
                //SOP("mayor "+cuentaMayores+": "+mayores[cuentaMayores]+"\n");
                cuentaMayores++;
            }
        }
        /*SOP("menores: ");
        imprimirArray(menores, cuentaMenores);
        SOP("pivote: "+pivote+"\n\nmayores: ");
        imprimirArray(mayores, cuentaMayores);
        paso = "menores";*/
        int[] menoresOrdenado = Arrays.copyOf(ordenarQuickSort(menores, cuentaMenores), cuentaMenores);
        //System.arraycopy(ordenarQuickSort(menoresTruncado), 0, menoresTruncado, 0, cuentaMenores);
        //paso = "mayores";
        int[] mayoresOrdenado = Arrays.copyOf(ordenarQuickSort(mayores, cuentaMayores), cuentaMayores);
        //System.arraycopy(ordenarQuickSort(mayoresTruncado), 0, mayoresTruncado, 0, cuentaMayores);

        /*SOP("menoresOrdenado: ");
        imprimirArray(menoresOrdenado);
        SOP("mayoresOrdenado: ");
        imprimirArray(mayoresOrdenado);*/

        int[] ordenado = Arrays.copyOf(menoresOrdenado, limite);
        //imprimirArray(ordenado);
        ordenado[cuentaMenores] = pivote;
        //imprimirArray(ordenado);
        System.arraycopy(mayoresOrdenado, 0, ordenado, cuentaMenores+1, cuentaMayores);
        /*imprimirArray(ordenado);
        
        SOP("ordenado: ");
        imprimirArray(ordenado);
        SOP("Sale\n");*/
        return ordenado;
    }
    public static void SOP(String aImprimir){
        System.out.print(aImprimir);
    }

    public static boolean estaOrdenado(int[] lista){
        //SOP("Dentro\n");
        for(int i=0; i<lista.length-1;i++){
            if(lista[i]>lista[i+1])return false;
        }
        //SOP("Fuera\n");
        return true;
    }

    public static void imprimirArray(int[] array){
        if(array.length == 0){System.out.println("{}\n");return;}
        String elArray = "{";
        for(int i = 0; i < array.length; i++){
            elArray += array[i]+(i==array.length-1?"}\n":",");
        }
        System.out.println(elArray);
    }

    public static void imprimirArray(int[] array, int limite){
        if(limite == 0 || array.length == 0){System.out.println("{}\n");return;}
        String elArray = "{";
        for(int i = 0; i < limite; i++){
            elArray += array[i]+(i==limite-1?"}\n":",");
        }
        System.out.println(elArray);
    }

}