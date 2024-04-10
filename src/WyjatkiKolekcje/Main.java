package WyjatkiKolekcje;
import java.util.Collection;
import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Integer> listy = new ArrayList<>();
        HashSet<Integer> zbior = new HashSet<>();
        LinkedList<Integer> lista_kierunk = new LinkedList<>();
        Stack<Integer> stos = new Stack<>();
        Vector<Integer> wektor = new Vector<>();
        PriorityQueue<Integer> kolejka = new PriorityQueue<>();
        TreeSet<Integer> drzewko = new TreeSet<>();



        // dodanie elementów i sprawdzenie czasu wykonywania operacji
        System.out.println("Czas wykonywania operacji add dla List: " + Main.moje_add(listy));
        System.out.println("Czas wykonywania operacji add dla Hashset: " + Main.moje_add(zbior));
        System.out.println("Czas wykonywania operacji add dla LinkdedList: " + Main.moje_add(lista_kierunk));
        System.out.println("Czas wykonywania operacji add dla Stack: " + Main.moje_add(stos));
        System.out.println("Czas wykonywania operacji add dla Stack: " + Main.moje_add(wektor));
        System.out.println("Czas wykonywania operacji add dla Stack: " + Main.moje_add(kolejka));
        System.out.println("Czas wykonywania operacji add dla Stack: " + Main.moje_add(drzewko));
        System.out.println("\n--------------------------------------------");


        // usuniecie elementów i sprawdzenie czasu wykonywania operacji
        System.out.println("Czas wykonywania operacji remove dla List: " + Main.moje_remove(listy));
        System.out.println("Czas wykonywania operacji remove dla Hashset: " + Main.moje_remove(zbior));
        System.out.println("Czas wykonywania operacji remove dla LinkdedList: " + Main.moje_remove(lista_kierunk));
        System.out.println("Czas wykonywania operacji remove dla Stack: " + Main.moje_remove(stos));
        System.out.println("Czas wykonywania operacji remove dla Stack: " + Main.moje_remove(wektor));
        System.out.println("Czas wykonywania operacji remove dla Stack: " + Main.moje_remove(kolejka));
        System.out.println("Czas wykonywania operacji remove dla Stack: " + Main.moje_remove(drzewko));
        System.out.println("\n--------------------------------------------");


        // dodawanie sprowrotem elementów
        Main.moje_add(listy);
        Main.moje_add(zbior);
        Main.moje_add(lista_kierunk);
        Main.moje_add(stos);
        Main.moje_add(wektor);
        Main.moje_add(kolejka);
        Main.moje_add(drzewko);


        // sprawdzenie czasu wykonywania operacji contains
        System.out.println("Czas wykonywania operacji contains dla List: " + Main.moje_contains(listy));
        System.out.println("Czas wykonywania operacji contains dla Hashset: " + Main.moje_contains(zbior));
        System.out.println("Czas wykonywania operacji contains dla LinkdedList: " + Main.moje_contains(lista_kierunk));
        System.out.println("Czas wykonywania operacji contains dla Stack: " + Main.moje_contains(stos));
        System.out.println("Czas wykonywania operacji contains dla Stack: " + Main.moje_contains(wektor));
        System.out.println("Czas wykonywania operacji contains dla Stack: " + Main.moje_contains(kolejka));
        System.out.println("Czas wykonywania operacji contains dla Stack: " + Main.moje_contains(drzewko));
        System.out.println("\n--------------------------------------------");


        // sprawdzenie  czasu wykonwania operacji toArray[]
        System.out.println("Czas wykonywania operacji toArray[] dla List: " + Main.moje_toArray(listy));
        System.out.println("Czas wykonywania operacji  toArray[] dla Hashset: " + Main.moje_toArray(zbior));
        System.out.println("Czas wykonywania operacji toArray[] dla LinkdedList: " + Main.moje_toArray(lista_kierunk));
        System.out.println("Czas wykonywania operacji toArray[] dla Stack: " + Main.moje_toArray(stos));
        System.out.println("Czas wykonywania operacji toArray[] dla Stack: " + Main.moje_toArray(wektor));
        System.out.println("Czas wykonywania operacji toArray[] dla Stack: " + Main.moje_toArray(kolejka));
        System.out.println("Czas wykonywania operacji toArray[] dla Stack: " + Main.moje_toArray(drzewko));
    }


    public static long moje_add(Collection kolekcja){
        long start = System.nanoTime();
        for(int i = 0; i < 100; ++i){
            kolekcja.add(i);
        }
        long end = System.nanoTime();
        return (end - start)/100;
    }

    public static long moje_remove(Collection kolekcja){
        long start = System.nanoTime();
        for(int i = 0; i  < 100; ++i){
            kolekcja.remove(i);
        }
        long end = System.nanoTime();
        return (end - start)/100;
    }

    public static long moje_contains(Collection kolekcja){
        long start = System.nanoTime();
        for(int i = 0; i  < 100; ++i){
            kolekcja.contains(i);
        }
        long end = System.nanoTime();
        return (end - start)/100;
    }

    public static long moje_toArray(Collection kolekcja){
        long start = System.nanoTime();
        Object[] tablica = kolekcja.toArray();
        long end = System.nanoTime();
        return (end - start)/100;
    }
}


