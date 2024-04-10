package KlasyInterfejsyItp.Zespolone.zespolone;

public class DoubleZespolona  {
    private double Re;
    private double Im;

    public DoubleZespolona(double Re, double Im){
        this.Im = Im;
        this.Re = Re;
    }

    public void show(){
        System.out.println(this.Re + "+i" + this.Im );
    }

    public DoubleZespolona add(DoubleZespolona skladnik){
        double Re = this.Re + skladnik.Re;
        double Im = this.Im + skladnik.Im;
        DoubleZespolona wynik = new DoubleZespolona(Re,Im);
        return wynik;
    }

    public DoubleZespolona multiply(DoubleZespolona skladnik){

        double Re = this.Re * skladnik.Re + this.Im * skladnik.Im * -1;
        double Im = this.Re * skladnik.Im + this.Im * skladnik.Re;
        DoubleZespolona wynik = new DoubleZespolona(Re,Im);
        return wynik;
    }

    public DoubleZespolona divide(DoubleZespolona skladnik){
        DoubleZespolona sprzezenie = new DoubleZespolona(skladnik.Re, -skladnik.Im);
        DoubleZespolona licznik = this.multiply(sprzezenie);
        double mianownik = skladnik.Re * skladnik.Re - -1* skladnik.Im * skladnik.Im;
        DoubleZespolona wynik = new DoubleZespolona(licznik.Re/mianownik, licznik.Im/mianownik);
        return wynik;
    }

}
