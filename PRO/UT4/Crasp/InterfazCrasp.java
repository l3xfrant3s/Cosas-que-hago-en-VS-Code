package PRO.UT4.Crasp;

import java.util.Scanner;

public class InterfazCrasp {
    private final char CONTINUAR = 'S';
    private JuegoCrasp juego;
    private Scanner teclado;
    public InterfazCrasp(){
        juego = new JuegoCrasp();
        teclado = new Scanner(System.in);
    }

    private void jugarAlCrasp(){
        juego.jugar();
        System.out.println("Has "+(juego.getGanado()?"ganado ":"perdido ")+juego.getNumeroTiradas()+" tirad"+(juego.getNumeroTiradas()==1?"a":"as"));
    }

    private char seguirJugando(){
        while(true){
            System.out.println("¿Quieres seguir jugando?(S/N)");
            String opcion = teclado.next();
            return opcion.charAt(1);
        }
    }
}