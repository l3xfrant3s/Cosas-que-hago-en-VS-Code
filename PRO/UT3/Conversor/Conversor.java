package PRO.UT3.Conversor;

public class Conversor{
    private double grados;
    public Conversor(){
        grados = 0.0;
    }
    public void setGrados(double cuantosGrados){
        grados = cuantosGrados;
    }
    public double aCentigrados(){
        return (grados-32)*5/9;
    }
    public double aFahrenheit(){
        return grados*9/5+32;
    }
    public double getGrados(){
        return grados;
    }
}