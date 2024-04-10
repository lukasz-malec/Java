package Wyprowadzenie.NWD;

public class Main {
    public static void main(String [] args){
        if(args.length == 0){
            System.out.println("Nie podano żadnych wartosci - koniec programu");
            System.exit(0);
        }else if(args.length > 2){
            System.out.println("Podano za duzo liczb - koniec programu");
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

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(NWD.algorymtEuklidesa(a,b));
    }
}