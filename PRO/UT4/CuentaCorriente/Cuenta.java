package PRO.UT4.CuentaCorriente;

public class Cuenta {
    private int nCuenta, saldo;
    private String nombreTitular;

    public Cuenta(int nCuenta, String nombreTitular){
        this.nCuenta = nCuenta;
        this.nombreTitular = nombreTitular;
        saldo = 0;
    }
}