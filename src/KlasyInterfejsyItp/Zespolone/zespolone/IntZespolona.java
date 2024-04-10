package KlasyInterfejsyItp.Zespolone.zespolone;

public class IntZespolona {
    private int Re;
    private int Im;

    public IntZespolona(int Re, int Im){
        this.Im = Im;
        this.Re = Re;
    }

    public void show(){
        System.out.println(this.Re + "+i" + this.Im );
    }


    public IntZespolona add(IntZespolona skladnik){
        int Re = this.Re + skladnik.Re;
        int Im = this.Im + skladnik.Im;
        IntZespolona wynik = new IntZespolona(Re,Im);
        return wynik;
    }

    public IntZespolona multiply(IntZespolona skladnik){

        int Re = this.Re * skladnik.Re + this.Im * skladnik.Im * -1;
        int Im = this.Re * skladnik.Im + this.Im * skladnik.Re;
        IntZespolona wynik = new IntZespolona(Re,Im);
        return wynik;
    }

    public IntZespolona divide(IntZespolona skladnik){
        IntZespolona sprzezenie = new IntZespolona(skladnik.Re, -skladnik.Im);
        IntZespolona licznik = this.multiply(sprzezenie);
        int mianownik = skladnik.Re * skladnik.Re - -1* skladnik.Im * skladnik.Im;
        IntZespolona wynik = new IntZespolona(licznik.Re/mianownik, licznik.Im/mianownik);
        return wynik;
    }

}

