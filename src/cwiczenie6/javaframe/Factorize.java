package cwiczenie6.javaframe;

import java.util.List;

public class Factorize implements Applayable {
    public void apply(Series v) {
        for (Value value : v.values) {
            int liczba = (Integer) value.value;
            int suma = 0;
            int i = 2; // Rozpoczynamy od pierwszej liczby pierwszej

            while (liczba > 1) {
                while (liczba % i == 0) {
                    suma += i;
                    liczba /= i;
                }
                i++;
            }

            value.value = suma;
        }
    }
}

