package PRO.UT4.Cuenta;

public class Cuenta{
    private String nombre;
    private static int ID = 0;
    private int NumeroCuenta;
    private double saldo = 0; // en Euros
    
    private int nuevoNC(){
        return ++ID;
    }
    
    public Cuenta(String comoSeLlama){ //abrir cuenta
        nombre = comoSeLlama;
        NumeroCuenta = nuevoNC();
    }
    
    public Cuenta(String comoSeLlama, double primerIngreso){ //abrir cuenta con saldo inicial
        nombre = comoSeLlama;
        NumeroCuenta = nuevoNC();
        saldo += primerIngreso;
    }
    
    public String ingresar(double ingreso){
        saldo += ingreso;
        return "Se ha producido un ingreso de " + ingreso + " euros.";
    }
    
    public void ingresoSilencioso(double ingreso){
        saldo += ingreso;
    }
    
    public String pagar(double adeudo){
        if (saldo < -1000) return "Tu saldo está por debajo del limite permitido de 1000 euros endeudados.\nSi quieres volver a realizar pagos, deberá ingresar hasta que se sobrepasen los -1000 euros.";
        saldo -= adeudo;
        if (saldo < -1000) return "Se ha producido un cargo de " + adeudo + " euros.\nTu saldo está por debajo del limite permitido de 1000 euros endeudados.\nSi quieres volver a realizar pagos, deberá ingresar hasta que se sobrepasen los -1000 euros.";
        if (saldo < 0) return "Se ha producido un cargo de " + adeudo + " euros.\nTu saldo es inferior a 0 euros.\nSi se reduce a menos de -1000 euros no podrá realizar más pagos.";
        return "Se ha producido un cargo de " + adeudo + " euros.";
    }
    
    public void pagoSilencioso(double adeudo){
        saldo -= adeudo;
    }
    
    public double saldoActual(){
        return saldo;
    }
    
    public String imprimirSaldoActual(){
        return "Tu saldo actual es " + saldo + " euros.";
    }
    
    public String cambiarNombre (String nuevoNombre){
        String viejoNombre = nombre;
        nombre = nuevoNombre;
        return "Se ha cambiado el titular de la cuenta de " + viejoNombre + " a " + nombre;
    }
    
    public String nombreActual(){
        return nombre;
    }
    
    public String imprimirNombreActual(){
        return nombre + " es el titular de esta cuenta";
    }
    
    public int miNumeroCuenta(){
        return NumeroCuenta; 
    }
    
    @Override
    public String toString(){
        return "Número de la cuenta: " + NumeroCuenta + "\nTitular: " + nombre + "\nSaldo actual: " + saldo;
    }
}
