package KlasyInterfejsyItp.MinimumFunkcji.funkcje;



public class Liniowa extends Funkcje {
    // funkcja postacji y = ax +b

    private double a,b;

    public Liniowa(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double getValue(double x) {
        return this.a * x + b;
    }

}