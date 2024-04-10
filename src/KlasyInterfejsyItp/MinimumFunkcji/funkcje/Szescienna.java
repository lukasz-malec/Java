package KlasyInterfejsyItp.MinimumFunkcji.funkcje;

public class Szescienna extends Funkcje{
    // funkcja postaci y = ax^3 + bx^2 + cx + d
    private double a,b,c,d;

    public Szescienna(double a, double b, double c,double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getValue(double x) {
        return this.a * x * x * x + this.b * x * x + this.c * x + d;
    }
}