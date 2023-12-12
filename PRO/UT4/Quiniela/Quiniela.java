package PRO.UT4.Quiniela;

public class Quiniela {

    private int jornada;

    public Quiniela(int queJornada){
        jornada = queJornada;
    }

    public void generarQuinielas(int cuantasQuinielas){
        for(int i = 0; i < cuantasQuinielas; i++){
            System.out.println("Jornada nº "+jornada+"\n    1 X 2");
            for(int j = 0; j < 15; j++){
                Partido elPartido = new Partido();
                elPartido.GenerarResultado();
                System.out.println(elPartido.toString());
            }
        }
    }

}
