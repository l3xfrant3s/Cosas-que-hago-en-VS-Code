package PRO.UT4.Crasp;

public class MainCrasp {
    public static void main(String[] args) {
        JuegoCrasp juego = new JuegoCrasp();
        juego.jugar();
        System.out.println((juego.getGanado()?"H":"No h")+"as ganado en "+juego.getNumeroTiradas()+" tirad"+(juego.getNumeroTiradas()==1?"a":"as"));
        System.out.println(juego.getNumeroTiradas());
    }
}
