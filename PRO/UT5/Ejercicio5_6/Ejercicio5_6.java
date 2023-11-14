package PRO.UT5.Ejercicio5_6;

public class Ejercicio5_6 {
    public static void main(String[] args) {
        double[] notitas = {8.0, 9.0, 10.0, 11.0};
        System.out.println(calcularMedia(notitas));
    }

    public static double calcularMedia(double[] notas){
        double suma = 0;
        for(int i = 0; i < notas.length; i++){
            suma += notas[i];
        }
        return suma/notas.length;
    }
}