package PRO.UT4.Embarque;

public class Ferry {
    private Pasajero asiento1, asiento2, asiento3;
    private int numPasajeros;

    public Ferry(){
        asiento1 = null;
        asiento2 = null;
        asiento3 = null;
        numPasajeros = 0;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void printDetallesPasajeros(){
        if(getNumPasajeros() == 0){
            System.out.println("No hay pasajeros");
            return;
        }

        System.out.println("Los pasajeros son:");
        for(int i = 0; i < getNumPasajeros(); i++){
            switch(i){
                case 1: asiento1.printDetalles();break;
                case 2: asiento2.printDetalles();break;
                case 3: asiento3.printDetalles();break;
            }
        }
    }

    public boolean añadirPasajero(Pasajero nuevoPasajero){
        switch(getNumPasajeros()){
            case 0: asiento1 = nuevoPasajero;
                    numPasajeros++;
                    return true;
            case 1: asiento2 = nuevoPasajero;
                    numPasajeros++;
                    return true;
            case 2: asiento3 = nuevoPasajero;
                    numPasajeros++;
                    return true;
            default:return false;
        }
    }

    public boolean añadirPasajeroPorNombre(String nombrePasajero){
        if(getNumPasajeros()>2) return false;
        Pasajero nuevoPasajero = new Pasajero(nombrePasajero);
        return añadirPasajero(nuevoPasajero);
    }

    public Pasajero borrarPasajero(){
        /*if(getNumPasajeros() != 0){
            Pasajero saliendo = asiento1;
            asiento1 = asiento2;
            asiento2 = asiento3;
            asiento3 = null;
            numPasajeros--;
            return saliendo;
        }*/
        Pasajero saliendo;
        switch(getNumPasajeros()){
            case 1: saliendo = asiento1;
                    asiento1 = null;
                    return saliendo;
            case 2: saliendo = asiento1;
                    asiento1 = asiento2;
                    asiento2 = null;
                    return saliendo;
            case 3: saliendo = asiento1;
                    asiento1 = asiento2;
                    asiento2 = asiento3;
                    asiento3 = null;
                    return saliendo;
            default: return null;
        }
    }

    public Pasajero getPasajeroMasJoven(){
        switch(getNumPasajeros()){
            case 1: return asiento1.getEdad() == -1?null:asiento1;
            case 2: 
                if(asiento1.getEdad() == -1){
                    if(asiento2.getEdad() == -1) return null; //Si el asiento 1 no tiene edad específica y el asiento 2 tampoco, devuelve nulo
                    return asiento2; // Si el asiento 2 tiene edad pero el 1 no, devuelve el asiento 2
                }
                if(asiento2.getEdad() == -1) return asiento1; // Si el asiento 1 tiene edad pero el 2 no, devuelve el asiento 1
                return masJovenDeDos(asiento1, asiento2);
            case 3:
                
        }
        return masJovenDeDos(asiento1, masJovenDeDos(asiento2, asiento3));
    }

    private Pasajero masJovenDeDos(Pasajero uno, Pasajero dos){
        return (uno.esMasJovenQue(dos)?uno:dos);
    }

}