package PRO.UT4.Crasp;

public class ParDados {
    private Dado dado1, dado2;

    public ParDados(){
        dado1 = new Dado();
        dado2 = new Dado();
    }

    public int tirarDados(){
        dado1.tirarDado();
        dado2.tirarDado();
        System.out.println("Salío "+(dado1.getCara()+dado2.getCara()));
        return dado1.getCara() + dado2.getCara();
    }
}
