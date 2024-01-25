package PRO.UT5.Bingo;

import PRO.UT5.FrecuenciaDado.main;

public class Prueba {
    public static boolean metodo(int algo){
        System.out.println(algo);
        return algo > 3;
    }
    public static void main(String[] args) {
        int valor;
        if(metodo(valor = (int)(Math.random()*10))){
            System.out.println("Algo funciona");
        }
        System.out.println(valor);
    }
}