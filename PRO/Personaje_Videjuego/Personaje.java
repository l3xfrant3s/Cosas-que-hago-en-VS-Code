public class Personaje {
    private String nombre;
    private int x, y;
    private char orientacion;
    private final char NORTE, SUR, ESTE, OESTE;
    public Personaje(String mote){
        nombre = mote;
        NORTE = 'N';
        SUR = 'S';
        ESTE = 'E';
        OESTE = 'O';
        x = 0;
        y = 0;
        orientacion = 'N';
    }
    @Override
    public String toString(){
        return "Personaje = "+nombre+"\nOrientacion = "+orientacion+"\nPosicion = ["+x+","+y+"]";
    }

    public void avanzar(int cuanto){
        switch(orientacion){
            case 'N':x += cuanto;break;
            case 'E':y += cuanto;break;
            case 'S':x -= cuanto;break;
            case 'O':y -= cuanto;break;
        }
    }

    public void girar(){
        switch(orientacion){
            case 'N':orientacion = ESTE;break;
            case 'E':orientacion = SUR;break;
            case 'S':orientacion = OESTE;break;
            case 'O':orientacion = NORTE;break;
        }
    }
}