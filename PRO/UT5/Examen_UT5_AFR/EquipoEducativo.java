package PRO.UT5.Examen_UT5_AFR;
import java.util.Arrays;

public class EquipoEducativo {
    private Profesor[] profesores;
    private int siguiente;

    public EquipoEducativo(){
        profesores = new Profesor[10];
        siguiente = 0;
    }

    public boolean addProfesor(Profesor nuevo){
        for(int i = 0; i < siguiente; i++){
            if(profesores[i].equals(nuevo)) return false;
        }
        profesores[siguiente] = nuevo;
        siguiente++;
        return true;
    }

    public void mostrarProfesores(){
        for(Profesor profesor:profesores){
            if(profesor == null) break;
            System.out.println(profesor.toString());
        }
    }

    public Profesor[] mostrarPorCargo(Cargo cargo){
        Profesor[] profesoresConCargo = new Profesor[siguiente];
        int nuevoProfesorConCargo = 0;
        for(int i = 0; i < siguiente; i++){
            if(profesores[i].getCargo() == cargo){
                profesoresConCargo[nuevoProfesorConCargo++] = profesores[i];
            }
        }
        return Arrays.copyOf(profesoresConCargo, nuevoProfesorConCargo);
    }

    public Profesor getProfesorMasJoven(){
        Profesor elMasJoven = profesores[0];
        for(Profesor profesor:profesores){
            if(profesor == null) break;
            if(profesor.getEdad() < elMasJoven.getEdad() || profesor.getEdad() == elMasJoven.getEdad() && profesor.getID() < elMasJoven.getID()){
                /*Si el profesor es mas joven que el que habiamos escogido o
                tienen la misma edad y el primero tiene un ID menor*/
                elMasJoven = profesor;
            }
        }
        return elMasJoven;
    }

    public Profesor borrarProfesor(String nombre){
        Profesor borrado = null;
        for(int i = 0; i < siguiente; i++){
            if(borrado != null){
                if(i + 1 == siguiente){//Si estamos en el ultimo elemento
                    profesores[i] = null;
                    siguiente--;
                    break;
                }
                profesores[i] = profesores[i+1];
            }
            else if(profesores[i].getNombre() == nombre){
                borrado = profesores[i];
            }
        }
        return borrado;
    }
}
