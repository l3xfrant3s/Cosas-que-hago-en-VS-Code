package PRO.Cafetera;

public class PruebaCafetera {
    public static void main(String[] args){
        Cafetera italiana = new Cafetera();
        System.out.printf("Maxima: %d\nActual: %d\n", italiana.getCapacidadMaxima(), italiana.getCantidadActual());
        System.out.println("Ahora voy a aumentar la capacidad a 1201 mililitros y añadir 500 mililitros de café");
        italiana.setCapacidadMaxima(1201);
        italiana.agregarCafe(500);
        System.out.printf("Maxima: %d\nActual: %d\n", italiana.getCapacidadMaxima(), italiana.getCantidadActual());
        System.out.println("Ahora voy a llenar la cafetera y repartirla entre mis 3 amigos y yo");
        italiana.llenarCafetera();
        for(int i = 0; i < 4; i++){
            System.out.printf("Quedan %d ml para %d personas más\n", italiana.getCantidadActual(), 4-i);
            italiana.servirTaza(300);
        }
        System.out.printf("Todavía queda %d ml, que voy a tirar por el fregadero\n", italiana.getCantidadActual());
        italiana.vaciarCafetera();
        System.out.printf("Ahora debería estar vacía y tener %d ml de café\n", italiana.getCantidadActual());
    }
}