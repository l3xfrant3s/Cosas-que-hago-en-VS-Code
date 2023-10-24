public class Ordenador{
    private int maxMemoria;
    private int memoriaInstalada;
    public Ordenador(int cuantaMemoriaMaxima){
        memoriaInstalada = 0;
        if(cuantaMemoriaMaxima > 0) maxMemoria = cuantaMemoriaMaxima;
        else maxMemoria = 1024;
        //maxMemoria = cuantaMemoriaMaxima > 0 ? cuantaMemoriaMaxima : 1024;
    }
    public int getMaxMemoria(){
        return maxMemoria;
    }
    public int getMemoriaDisponible(){
        return maxMemoria - memoriaInstalada;
    }
    public void printInformacion(){
        System.out.println("Este ordenador puede tener hasta " + maxMemoria + " Mb de memoria.\nTodavía es posible instalar " + getMemoriaDisponible() + " Mb más.");
    }
    public void vaciarMemoria(){
        memoriaInstalada = 0;
    }
    public boolean instalar256Mb(){
        if (getMemoriaDisponible() >= 256){
            memoriaInstalada += 256;
            return true;
        }
        return false;
    }
    public boolean instalarMemoria(int cuantaMemoria){
        if (getMemoriaDisponible() >= cuantaMemoria){
            memoriaInstalada += cuantaMemoria;
            return true;
        }
        return false;
    }
}