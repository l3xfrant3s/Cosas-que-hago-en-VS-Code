package PRO.UT4.Fraccion;

public class Fraccion {
    private int numerador, denominador;
    public Fraccion (){
        numerador = 0;
        denominador = 1;
    }
    public Fraccion(int queNum, int queDen){
        numerador = queNum;
        denominador = queDen;
    }

    public int getDenominador() {
        return denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public void setDenominador(int queDen) {
        denominador = queDen;
    }

    public void setNumerador(int queNum) {
        numerador = queNum;
    }

    public Fraccion sumar (Fraccion otra){
        int novDen = 0;
        int novNum = 0;
        if(this.getDenominador() != otra.getDenominador()){
            novDen = this.getDenominador()*otra.getDenominador();
            novNum = this.getNumerador()*otra.getDenominador() + otra.getNumerador()*this.getDenominador();
        }
        else{
            novDen = this.denominador;
            novNum = this.getNumerador() + otra.getDenominador();
        }
        return new Fraccion(novNum, novDen);
    }

    public Fraccion restar (Fraccion otra){
        int novDen = 0;
        int novNum = 0;
        if(this.getDenominador() != otra.getDenominador()){
            novDen = this.getDenominador()*otra.getDenominador();
            novNum = this.getNumerador()*otra.getDenominador() - otra.getNumerador()*this.getDenominador();
        }
        else{
            novDen = this.denominador;
            novNum = this.getNumerador() - otra.getDenominador();
        }
        return new Fraccion(novNum, novDen);
    }

    public Fraccion multiplicar (Fraccion otra){
        return new Fraccion(this.getNumerador()*otra.getNumerador(), this.getDenominador()*otra.getDenominador());
    }

    public Fraccion dividir (Fraccion otra){
        return new Fraccion(this.getNumerador()*otra.getDenominador(), this.getDenominador()*otra.getNumerador());
    }

    public boolean igualQue(Fraccion otra){
        return this.getNumerador() == otra.getNumerador() && this.getDenominador() == otra.getDenominador();
    }

    public boolean menorQue(Fraccion otra){
        return Double.valueOf(this.getNumerador())/Double.valueOf(this.getDenominador()) < Double.valueOf(otra.getNumerador())/Double.valueOf(otra.getDenominador());
    }
    public Fraccion clonar(){
        return new Fraccion(this.numerador, this.denominador);
    }

    public String toString(){
        return this.numerador+" / "+this.denominador;
    }
}