import java.util.Scanner;

public class SociosClub{
    
    private Socio[] socios = new Socio[3]; //con un array es muy facil convertir esta clase para que acepte el maximo de socios como parametro en el constructor
    private int total;
    private final int NUMERARIO = 10;
    private final int NO_NUMERARIO = 20;
    private final int FAMILIAR = 30;
    
    public SociosClub(){
        total = 0;
    }
    
    public int cuantosFamiliares(){
        int cuentaFamiliares = 0;
        for(int i = 0; i < total; i++){
            if(socios[i].getTipoSocio() == FAMILIAR) cuentaFamiliares++;
        }
        return cuentaFamiliares;
    }
    
    public void aniadirSocio(int tipo, String DNI, String nombre, String primerApellido){
        socios[total] = new Socio(tipo, DNI, nombre, primerApellido);
        total++;
    }
    
    public void listarSocios(){
        if(total == 0) {
            System.out.println("No hay ningún socio en la biblioteca");
            return;
        }
        for(int i = 0; i < total; i++){
            System.out.println("Socio "+(i+1)+":\n"+socios[i].toString()+"\n");
        }
    }
    
    public int borrarNumerarios(){
        int numerariosBorrados = 0;
        int copiaTotal = total;
        for(int i = 0; i < copiaTotal; i++){
            if (esNumerario(socios[i])){
                socios[i] = null;
                numerariosBorrados++;
                total--;
            }
            else if (!esNumerario(socios[i]) && numerariosBorrados != 0){
                socios[i-numerariosBorrados] = socios[i]; //i-numerariosBorrados es la posicion del primer nulo si se ha borrado algun numerario
                socios[i] = null;
            }
        }
        return numerariosBorrados;
    }
    
    private boolean esNumerario(Socio unSocio){
        return unSocio.getTipoSocio() == NUMERARIO;
    }
    
    public static void cosaConNumerosAleatorios(){
        int aleatorio = 0;
        int cuentaDieces = 0;
        int sumaPares = 0;
        for(int i = 0; i < 10; i++){
            aleatorio = (int)(Math.random()*10)+10;
            System.out.println(aleatorio);
            cuentaDieces += aleatorio==10?1:0;
            sumaPares += aleatorio%2==0?aleatorio:0;
        }
        System.out.println("El número 10 ha salido "+cuentaDieces+" ve"+(cuentaDieces==1?"z":"ces"));
        System.out.println("La suma de los pares fue "+sumaPares);
    }
    
    public static void vocalesTecleadas(){
        Scanner teclado = new Scanner(System.in);
        char ultimoTecleado = ' ';
        int cuentaVocales = 0;
        int aleatorio = (int)(Math.random()*100);
        while(true){
            System.out.println("Sigue"+(aleatorio==(int)(Math.random()*100)?" (Puede introducir X [mayus + x] para salir)":""));
            ultimoTecleado = teclado.nextLine().charAt(0);
            if(ultimoTecleado == 'a' || ultimoTecleado == 'e' || ultimoTecleado == 'i' || ultimoTecleado == 'o' || ultimoTecleado == 'u' ||
            ultimoTecleado == 'A' || ultimoTecleado == 'E' || ultimoTecleado == 'I' || ultimoTecleado == 'O' || ultimoTecleado == 'U'){
                cuentaVocales++;
            }
            else if(ultimoTecleado == 'X'){
                System.out.println("¡Alto!");
                break;
            }
        }
        System.out.println("Ha introducido "+cuentaVocales+" vocal"+(cuentaVocales==1?"":"es"));
        teclado.close();
    }
}
