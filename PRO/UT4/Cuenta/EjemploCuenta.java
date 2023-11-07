package PRO.UT4.Cuenta;

public class EjemploCuenta{
    public static void main(String[] args){
        Cuenta cliente1 = new Cuenta ("El Pepe");
        Cuenta cliente2 = new Cuenta ("Mamañema", 500);
        System.out.println(cliente2);
        System.out.println(cliente1.imprimirSaldoActual());
        System.out.println(cliente1.miNumeroCuenta());
        System.out.println(cliente1.ingresar(400));
        System.out.println(cliente1.pagar(17.49));
        System.out.println(cliente1.pagar(8.82));
        System.out.println(cliente1.imprimirSaldoActual());
        cliente1.pagoSilencioso(1200);
        System.out.println(cliente1.imprimirSaldoActual());
        System.out.println(cliente1.pagar(10));
        System.out.println(cliente1.pagar(120));
        System.out.println(cliente1.pagar(120));
        System.out.println(cliente1);
    }
}
