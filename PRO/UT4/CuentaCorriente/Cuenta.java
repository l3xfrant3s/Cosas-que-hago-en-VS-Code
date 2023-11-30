package PRO.UT4.CuentaCorriente;

public class Cuenta {
    private int nCuenta, saldo;
    private String nombreTitular;

    public Cuenta(int nCuenta, String nombreTitular){
        this.nCuenta = nCuenta;
        this.nombreTitular = nombreTitular;
        saldo = 0;
    }

    public void ingreso(int cuanto){
        saldo += cuanto;
    }

    public void reintegro(int cuanto){
        saldo -= cuanto;
    }

    public int consultarSaldo(){
        return saldo;
    }

    @Override
    public String toString(){
        return "Titular: "+nombreTitular+"\nNúmero de cuenta: "+nCuenta+"\nSaldo actual: "+saldo+"\n";
    }
}