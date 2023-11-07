package PRO.UT3.Dinero;

public class Dinero {
    private int euros;
    private final int MONEDA_1 = 1;
    private final int MONEDA_2 = 2;
    private final int BILLETE_5 = 5;
    private final int BILLETE_10 = 10;
    private final int BILLETE_20 = 20;
    public Dinero(int cuantosEuros){
        if(cuantosEuros > 0 && cuantosEuros < 100)euros = cuantosEuros;
        else System.out.println("¡Es una operación demasiado arriesgada! No podemos lav... contar tanto dinero.");
    }

    public int getDinero(){return euros;}
    public void setDinero(int cuantosEuros){
        if(cuantosEuros > 0 && cuantosEuros < 100)euros = cuantosEuros;
    }
    public void printDescomposicionMonedas(){
        int temp = euros;
        int de20 = temp / BILLETE_20;
        temp = temp % BILLETE_20;
        int de10 = temp / BILLETE_10;
        temp = temp % BILLETE_10;
        int de5 = temp / BILLETE_5;
        temp = temp % BILLETE_5;
        int de2 = temp / MONEDA_2;
        temp = temp % MONEDA_2;
        int de1 = temp / MONEDA_1;
        temp = temp % MONEDA_1;
        System.out.println(euros + " euros son:");
        if (de20 > 0){
            System.out.print(de20 + " billete");
            System.out.print(de20 != 1 ? "s":"");
            System.out.println(" de 20 euros");
        }
        if (de10 > 0){
            System.out.print(de10 + " billete");
            System.out.print(de10 != 1 ? "s":"");
            System.out.println(" de 10 euros");
        }
        if (de5 > 0){
            System.out.print(de5 + " billete");
            System.out.print(de5 != 1 ? "s":"");
            System.out.println(" de 5 euros");
        }
        if (de2 > 0){
            System.out.print(de2 + " moneda");
            System.out.print(de2 != 1 ? "s":"");
            System.out.println(" de 2 euros");
        }
        if (de1 > 0){
            System.out.print(de1 + " moneda");
            System.out.print(de1 != 1 ? "s":"");
            System.out.println(" de 1 euros");
        }
    }
}