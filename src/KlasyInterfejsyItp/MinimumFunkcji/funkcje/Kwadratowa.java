package KlasyInterfejsyItp.MinimumFunkcji.funkcje;

public class Kwadratowa extends Funkcje{
    // funckja postaci y = ax^2 + bx + c
    private double a,b,c;


    public Kwadratowa(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getValue(double x) {
        return this.a * x * x + this.b * b + c;
    }

}
