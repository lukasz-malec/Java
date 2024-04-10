package Wyprowadzenie.SREDNIOGEO;

import java.util.*;
public class SredniaGeo {
    private Vector<Integer> wektor;

    public SredniaGeo(String [] array) {
        Vector<Integer> wektor = new Vector<Integer>();
        for (int i = 0; i < array.length; ++i) {
            wektor.add(Integer.parseInt(array[i]));
        }
        this.wektor = wektor;
    }

    public double wynik(){
        int wynik = 1;
        int dlugosc = this.wektor.size();
        for( int elem : wektor){
            wynik *= elem;
        }
        return Math.pow(wynik, 1.0/dlugosc);
    }
}
