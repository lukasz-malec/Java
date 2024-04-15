package ObslugaI0_Strumienie.Counter;

import java.io.*;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = null;
        HashMap<Character, Integer> mapaZnaki = new HashMap<>();
        HashMap<String, Integer> mapaSłowa = new HashMap<>();

        char znak = 'a';
        while (znak != 'z') {
            mapaZnaki.put(znak, 0);
            ++znak;
        }
        mapaZnaki.put('z', 0);

        int liczbaLinii = 0;
        int liczbaZdan = 0;

        try {
            in = new Scanner(new BufferedReader(new FileReader("src\\ObslugaI0_Strumienie\\Counter\\input.txt")));

            Zliczanieliter(in, mapaZnaki);

            // Resetowanie skanera, bo przeczytał już  cały plik
            in = new Scanner(new BufferedReader(new FileReader("src\\ObslugaI0_Strumienie\\Counter\\input.txt")));
            while (in.hasNextLine()) {
                in.nextLine();
                liczbaLinii++;
            }

            // Resetowanie skanera, bo przeczytał  już cały  plik
            in = new Scanner(new BufferedReader(new FileReader("src\\ObslugaI0_Strumienie\\Counter\\input.txt")));
            mapaSłowa = ZliczanieSłow(in);


            // Resetowanie skanera, bo przeczytał  już cały  plik
            in = new Scanner(new BufferedReader(new FileReader("src\\ObslugaI0_Strumienie\\Counter\\input.txt")));
            in.useDelimiter("\\.");
            while (in.hasNext()) {
                in.next();
                liczbaZdan++;
            }




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        for (Map.Entry<Character, Integer> elem : mapaZnaki.entrySet()) {
            if (elem.getValue() != 0) {
                System.out.println(elem.getKey() + ": " + elem.getValue() + " razy");
            }
        }
        for (Map.Entry<String, Integer> elem : mapaSłowa.entrySet()) {
            if (elem.getValue() != 0) {
                System.out.println(elem.getKey() + ": " + elem.getValue() + " razy");
            }
        }

        System.out.println("Liczba linii: " + liczbaLinii);
        System.out.println("Liczba zdań: " + liczbaZdan);
    }


    public static void Zliczanieliter(Scanner in, Map<Character, Integer> mapa) {
        String token;
        while (in.hasNext()) {
            token = in.next();
            char[] tablica = token.toCharArray();

            // zamiana na małe litery
            for(int i = 0; i < tablica.length; i++){
                tablica[i] = Character.toLowerCase(tablica[i]);
            }

            // zliczanie wystapien znakow i zwiekszanie value hashmapy
            for (char elem : tablica) {
                if (mapa.containsKey(elem)) {
                    int counter = mapa.get(elem);
                    counter++;
                    mapa.put(elem, counter);
                }
            }
        }
    }


    public static HashMap<String,Integer> ZliczanieSłow(Scanner in) {
        Vector<String> wektor = new Vector<>();

        while (in.hasNext()) {
            wektor.add(in.next());
        }
        HashMap<String, Integer> mapa = new HashMap<>();

        for (String elem : wektor) {
            mapa.put(elem, mapa.getOrDefault(elem, 0) + 1);
        }

        return mapa;
    }

}