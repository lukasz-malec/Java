package cwiczenie1;

public class Main {
    public static void main(String[] args) {
        if(args.length == 1){
            PESEL pesel1 = new PESEL(args[0]);
            PESEL.check(pesel1);
            if(PESEL.poprawnosc == true){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        } else if(args.length == 2) {
            PESEL pesel1 = new PESEL(args[0]);
            PESEL pesel2 = new PESEL(args[1]);
            PESEL.check(pesel1);
            PESEL.check(pesel2);
            if (PESEL.poprawnosc == false) {
                System.out.println(0);
            } else {
                pesel1.compare(pesel1, pesel2);
            }
        } else{
            System.out.println(0);
        }
    }
}
