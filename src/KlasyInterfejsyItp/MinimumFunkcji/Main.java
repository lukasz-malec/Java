package KlasyInterfejsyItp.MinimumFunkcji;
import KlasyInterfejsyItp.MinimumFunkcji.funkcje.*;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Jakiego stopnia funkcji chcesz obliczyć minimum (od 1 do 3): ");
        int stopien = scan.nextInt();

        Funkcje funkcja;
        double[] wspolczynniki = new double[stopien + 1];

        switch (stopien) {
            case 1:
                System.out.println("Podaj współczynniki do funkcji linowej");
                break;
            case 2:
                System.out.println("Podaj współczynniki do funkcji kwadratowej");
                break;
            case 3:
                System.out.println("Podaj współczynniki do funkcji sześciennej");
                break;
            default:
                System.out.println("Niepoprawny stopień funkcji.");
                return;
        }

        for (int i = 0; i <= stopien; i++) {
            wspolczynniki[i] = scan.nextDouble();
        }

        switch (stopien) {
            case 1:
                funkcja = new Liniowa(wspolczynniki[0], wspolczynniki[1]);
                break;
            case 2:
                funkcja = new Kwadratowa(wspolczynniki[0], wspolczynniki[1], wspolczynniki[2]);
                break;
            case 3:
                funkcja = new Szescienna(wspolczynniki[0], wspolczynniki[1], wspolczynniki[2], wspolczynniki[3]);
                break;
            default:
                return;
        }

        System.out.println("Podaj w jakim przedziale ma być liczone minimum");
        double poczatek = scan.nextDouble();
        double koniec = scan.nextDouble();
        System.out.println(funkcja.findMinimum(poczatek, koniec, 0.1));
    }
}

