package Wyprowadzenie.SREDNIOGEO;

public class Main {
    public static void main(String [] args){
        if(args.length == 0){
            System.out.println("Nie podano żadnych wartosci - koniec programu");
            System.exit(0);
        }


        // gdyby parametr nie okazał się wyłacznie liczba
        for(String elem : args){
            if(elem.matches("\\d+")){
                continue;
            }else{
                System.out.println("Podałes parametr, który nie jest liczbą - koniec programu");
                System.exit(0);
            }
        }

        SredniaGeo obiekt = new SredniaGeo(args);
        System.out.println("Srednia geometryczna wynosi: " + obiekt.wynik());
    }
}

