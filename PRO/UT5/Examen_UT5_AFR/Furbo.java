package PRO.UT5.Examen_UT5_AFR;

public class Furbo{
	private final int NUMJUGADORES = 10;
	private final int EQUIPOS = 5;
	private int[][] golesJugadores;
	private final String[] nombresEquipos = {"Barcelona", "Real Madrid", "GranCa", "Juventud", "Unicaja"};
	public Furbo(){
		golesJugadores = new int[EQUIPOS][NUMJUGADORES];
		iniciar();
	}
	
	private	void iniciar(){
		for(int i = 0; i < golesJugadores.length; i++){
			for(int j = 0; j < golesJugadores[i].length; j++){
				golesJugadores[i][j] = (int)(Math.random()*100) + 1;
			}
		}
	}
	
	public void printMaximoAnotador(){
		int equipoConMaximoAnotador = -1;
		int golesMaximoAnotador = 0;
		for(int i = 0; i < golesJugadores.length; i++){
			for(int j = 0; j < golesJugadores[i].length; j++){
				if(golesJugadores[i][j] > golesMaximoAnotador){
					golesMaximoAnotador = golesJugadores[i][j];
					equipoConMaximoAnotador	= i;
				}
			}
		}
		System.out.println(nombresEquipos[equipoConMaximoAnotador]);
	}
}