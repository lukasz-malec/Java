package KlasyInterfejsyItp.Zespolone;

import KlasyInterfejsyItp.Zespolone.zespolone.DoubleZespolona;
import KlasyInterfejsyItp.Zespolone.zespolone.IntZespolona;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Jakiego typu będą liczby zespolone:\n1 - int\n2 - double\nWybierz opcję");
        String odpowiedz = scan.nextLine();

        if (odpowiedz.equals("1") || odpowiedz.equals("2")) {
            System.out.println("Podaj liczbę zespoloną w postaci (a+ib):");
            String text = scan.nextLine();

            if (text.matches("\\d+\\+i\\d+")) {
                int index = text.indexOf("i");
                String[] parts = new String[3];
                parts[0] = text.substring(0, index - 1);
                parts[1] = "i";
                parts[2] = text.substring(index + 1, text.length());

                if (odpowiedz.equals("1")) {
                    IntZespolona liczba = new IntZespolona(Integer.parseInt(parts[0]), Integer.parseInt(parts[2]));
                    operacjeZespolone(liczba);
                } else {
                    DoubleZespolona liczba = new DoubleZespolona(Double.parseDouble(parts[0]), Double.parseDouble(parts[2]));
                    operacjeZespolone(liczba);
                }
            } else {
                System.out.println("Podano złą wartość - koniec programu");
            }
        } else {
            System.out.println("Podano nieprawidłową opcję - koniec programu");
        }
    }

    public static void operacjeZespolone(DoubleZespolona liczba) {
        // Przykładowe operacje dla liczby zespolonej z = 2+3i
        liczba.add(new DoubleZespolona(2, 3)).show();
        liczba.multiply(new DoubleZespolona(2, 3)).show();
        liczba.divide(new DoubleZespolona(2, 3)).show();
    }


    public static void operacjeZespolone(IntZespolona liczba) {
        // Przykładowe operacje dla liczby zespolonej z = 2+3i
        liczba.add(new IntZespolona(2, 3)).show();
        liczba.multiply(new IntZespolona(2, 3)).show();
        liczba.divide(new IntZespolona(2, 3)).show();
    }
}

