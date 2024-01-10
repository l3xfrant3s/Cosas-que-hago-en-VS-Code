package PRO.UT5.FrecuenciaDado;

public class FrecuenciaDado {
    private Dado dado;
    private int[] frecuencia = new int[6];

    public FrecuenciaDado(){
        dado = new Dado();
    }

    public void tirarDado(int veces){
        for(int i = 0; i < veces; i++){
            frecuencia[dado.tirarDado()-1]++;
        }
    }

    public void escribirFrecuencia(){
        System.out.println("Cara    Frecuencia");
        for(int i = 0; i < 6; i++){
            System.out.println((i+1)+"       "+frecuencia[i]);
        }
    }
}