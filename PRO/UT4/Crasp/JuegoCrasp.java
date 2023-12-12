package PRO.UT4.Crasp;

public class JuegoCrasp {
    private ParDados dados;
    private boolean ganado;
    private int numeroTiradas;
    public JuegoCrasp(){
        dados = new ParDados();
        reset();
    }

    public void reset(){
        numeroTiradas = 0;
        ganado = false;
    }

    public int getNumeroTiradas() {
        return numeroTiradas;
    }

    public boolean getGanado(){
        return ganado;
    }

    public void jugar(){
        int punto = dados.tirarDados();
        switch(punto){
            case 7, 11: numeroTiradas++;ganado = true;break;
            case 2, 3, 12: numeroTiradas++;ganado = false;break;
            case 4, 5, 6, 8, 9, 10:{
                int punto2 = punto;
                while(true){
                    punto2 = dados.tirarDados();
                    numeroTiradas++;
                    if(punto == punto2){ganado=true;break;}
                    if(punto == 7){ganado=false;break;}
                }
                break;
            }
        }
    }
}
