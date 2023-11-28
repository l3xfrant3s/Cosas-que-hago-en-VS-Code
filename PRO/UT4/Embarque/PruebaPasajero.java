package PRO.UT4.Embarque;

/**
 * PruebaPasajero
 */
public class PruebaPasajero {

    private Pasajero pasajero1, pasajero2;

    public PruebaPasajero(String queNombre1, String queNombre2, int cuantosAños2){
        pasajero1 = new Pasajero(queNombre1);
        pasajero1 = new Pasajero(queNombre2, cuantosAños2);
    }
}