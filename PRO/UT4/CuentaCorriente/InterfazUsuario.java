package PRO.UT4.CuentaCorriente;

import java.util.Scanner;

public class InterfazUsuario {
    private final int INGRESO = 1;
    private final int REINTEGRO = 2;
    private final int CONSULTA = 3;
    private final int IMPRIMIR = 4;
    private final int SALIR = 5;
    private Cuenta cuenta;
    private Scanner teclado;

    public InterfazUsuario(){
        teclado = new Scanner(System.in);
    }

    private int menu(){
        System.out.println("1.-Ingreso\n2.-Reintegro\n3.-Consulta\n4.-Imprimir datos cuenta\n5.-Salir\n        Elija opción:");
        return teclado.nextInt();
    }

    private void borrarPantalla(){}

    public void iniciar(){
        int opcion = 0;
        while(true){
            opcion = menu();
            switch (opcion) {
                case INGRESO: realizarIngreso();break;
                case REINTEGRO: realizarReintegro();break;
                case CONSULTA: consultarSaldo();break;
                case IMPRIMIR: imprimirDatosCuenta();break;
                case SALIR: return;
                default: System.out.println("Opción invalida, por favor inténtelo de nuevo");break;
            }
        }
    }

    private void realizarIngreso(){
        System.out.println("¿Cuánto desea ingresar?");
        cuenta.ingreso(teclado.nextInt());
    }

    private void realizarReintegro(){
        System.out.println("¿Cuánto desea retirar?");
        cuenta.reintegro(teclado.nextInt());
    }

    private void consultarSaldo(){
        System.out.println("Saldo actual: "+cuenta.consultarSaldo());
    }

    private void imprimirDatosCuenta(){
        System.out.println(cuenta);
    }
}
