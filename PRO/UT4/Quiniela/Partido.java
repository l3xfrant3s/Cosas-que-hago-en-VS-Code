package PRO.UT4.Quiniela;

public class Partido {
    private static int proximoPartido = 1;
    private int numeroPartido;
    private char resultado;

    public Partido(){
        numeroPartido = proximoPartido;
        proximoPartido++;
        if(proximoPartido > 15) proximoPartido = 1;
    }
    
    public char getResultado(){
        return resultado;
    }

    public void GenerarResultado(){
        int resultadinho = (int)(Math.random()*3);
        switch(resultadinho){
            case 0: resultado = 'X';break;
            case 1: resultado = '1';break;
            case 2: resultado = '2';break;
        }
    }

    public String toString(){
        return (numeroPartido<10?"0":"")+numeroPartido+": "+
        (resultado=='X'?"_ X _":(resultado=='1'?"X _ _":"_ _ X"));
    }
}
