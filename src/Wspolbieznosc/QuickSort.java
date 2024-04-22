package Wspolbieznosc;

public class QuickSort {
    static void sortowanieSzybkie(int tab[], int indeksPoczatkowy, int indeksKoncowy)
    {
        if(indeksPoczatkowy < indeksKoncowy) {
            int indeksPodzialu = podzielTablice(tab, indeksPoczatkowy, indeksKoncowy);
            sortowanieSzybkie(tab, indeksPoczatkowy, indeksPodzialu - 1);
            sortowanieSzybkie(tab, indeksPodzialu + 1, indeksKoncowy);
        }
    }

    static int podzielTablice(int tab[], int indeksPoczatkowy, int indeksKoncowy)
    {
        int pivot = tab[indeksKoncowy];
        int indeksElementuMniejszegoOdPivota = indeksPoczatkowy - 1;

        for(int indeksPoszukujacy = indeksPoczatkowy; indeksPoszukujacy < indeksKoncowy; indeksPoszukujacy++){
            if(tab[indeksPoszukujacy] < pivot){
                indeksElementuMniejszegoOdPivota++;

                int temp = tab[indeksElementuMniejszegoOdPivota];
                tab[indeksElementuMniejszegoOdPivota] = tab[indeksPoszukujacy];
                tab[indeksPoszukujacy] = temp;
            }
        }

        int temp = tab[indeksElementuMniejszegoOdPivota + 1];
        tab[indeksElementuMniejszegoOdPivota + 1] = tab[indeksKoncowy];
        tab[indeksKoncowy] = temp;

        return indeksElementuMniejszegoOdPivota + 1;
    }

}
