package cwiczenie6;

import cwiczenie6.javaframe.*;

public class Main {
    public static void main(String[] args){
        String filename = args[0];
        String columnName = args[1];
        int threadNumber = Integer.valueOf(args[2]);
        int indexOutTerminal = Integer.valueOf(args[3]);
        Factorize  fact = new Factorize();
        Series result = null;

        try {
            Class<? extends Value>[] types = new Class[]{Int.class};
            DataFrame df = DataFrame.readCSV(filename, types);
            result = df.apply(fact,columnName,threadNumber);
            System.out.println(result.get(indexOutTerminal));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}