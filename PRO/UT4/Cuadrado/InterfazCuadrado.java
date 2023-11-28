package PRO.UT4.Cuadrado;

import java.util.Scanner;

public class InterfazCuadrado {
    private Scanner teclado;

    public InterfazCuadrado(){
        teclado= new Scanner(System.in);
    }
    public void iniciar(){
        int opcion=menu();
    }

    public int menu(){
        System.out.println("Opciones de Dibujo");
        System.out.println("Contorno.........1");
        System.out.println("Bicolor..........2");
        System.out.println("Aspa.............3");
        System.out.println("Salir............4");
        System.out.print("\nElija Opcion: ");
        return teclado.nextInt();
    }
}
