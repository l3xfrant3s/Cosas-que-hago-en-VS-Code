package PRO.UT3.Pelicula;

public class PruebaPelicula{
    public static void main(String[] args){
        Pelicula muchosAhoraMismo = new Pelicula("Las Aventuras de un Alumno Desesperado", "Alexis Felipe Rodríguez", 110, 5);
        muchosAhoraMismo.setCalificacion(4.9);
        muchosAhoraMismo.imprimir();
        //Pruebas con géneros no existentes
        muchosAhoraMismo.setGenero(6);
        muchosAhoraMismo.setGenero(0);
        //Pruebas con duraciones negativas
        muchosAhoraMismo.setDuracion(-1);
        muchosAhoraMismo.setDuracion(-110);
        //Pruebas con años de estreno imposibles: antes de que se inventara la película (si pudiera usar internet buscaba el año exacto ;) ) o en el futuro
        muchosAhoraMismo.setAnioEstreno(2030);
        muchosAhoraMismo.setAnioEstreno(1815);
        //Pruebas con calificaciones fuera del rango de 0 a 10
        muchosAhoraMismo.setCalificacion(11);
        muchosAhoraMismo.setCalificacion(-1);
        //Nada debería haber cambiado
        muchosAhoraMismo.imprimir();
        System.out.println(muchosAhoraMismo.getNombre()+" tiene una puntuación de "+muchosAhoraMismo.getValorPeli()+" en el Scorímetro y "+
        (muchosAhoraMismo.esBuenaPeli()?"se considera una buena película":"tiene una calificación mixta"));
        Pelicula unPelinMasSerio= new Pelicula("Transformers", "Steven Spielberg" /*?*/, 90, 1);
        unPelinMasSerio.setAnioEstreno(2007);
        unPelinMasSerio.setCalificacion(9);//No tengo internet para buscar la calificación real en RottenTomatoes o algo así
        unPelinMasSerio.imprimir();
        System.out.println(unPelinMasSerio.getNombre()+" tiene una puntuación de "+unPelinMasSerio.getValorPeli()+" en el Scorímetro y "+
        (unPelinMasSerio.esBuenaPeli()?"se considera una buena película":"tiene una calificación mixta"));//1500*9=13500
    }
}
