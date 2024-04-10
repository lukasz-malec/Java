package Wyprowadzenie.NWD;

public class NWD {
    public static int algorymtEuklidesa(int a, int b){
        int reszta = a % b;
        if ( reszta == 0){
            return b;
        }else{
            return algorymtEuklidesa(b,reszta);
        }
    }
}