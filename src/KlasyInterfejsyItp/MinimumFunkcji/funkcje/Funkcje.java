package KlasyInterfejsyItp.MinimumFunkcji.funkcje;

public abstract class Funkcje {
    public abstract double getValue(double x);

    public double findMinimum(double a, double b, double precyzja){
        double minimum = this.getValue(a);
        double argMinimum = a;

        for (double i = a + precyzja; i <= b; i += precyzja) {
            double value = this.getValue(i);
            if (value < minimum) {
                minimum = value;
                argMinimum = i;
            }
        }
        return argMinimum;
    }
}
