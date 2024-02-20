package PRO.UT5.Examen_UT5_AFR;

public class Main {
    public static void main(String[] args) {
        /*Profesor fol = new Profesor("Marisol", 50, Cargo.DOCENTE);
        Profesor bae = new Profesor("Carlos", 48, Cargo.COORDINADOR);*/
        Profesor pro = new Profesor("Miguel Angel:52");
        Profesor invalido = new Profesor("No:existo");
        EquipoEducativo delRincon = new EquipoEducativo();
        /*delRincon.addProfesor(fol);
        delRincon.addProfesor(bae);*/
        delRincon.addProfesor(pro);
        delRincon.addProfesor(invalido);
        delRincon.mostrarProfesores();
        Profesor[] docentes = delRincon.mostrarPorCargo(Cargo.DOCENTE);
        for(int i = 0; i < docentes.length; i++){
            System.out.println(docentes[i]);
        }
        
		Furbo copinia = new Furbo();
		copinia.printMaximoAnotador();
    }
}