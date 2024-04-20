package ObslugaI0_Strumienie.Cezar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            if(args.length != 3){
                System.out.println("Podałej za mało argumentów. Prawidłowa liczba parametrów wywołania to 3:");
                System.out.print("<input_file> <output_file> <rotacja>");
            }

            String input_name = args[0];
            String output_name = args[1];
            int rotacja = Integer.getInteger(args[2]);

            Cryptfile cryptfile = new Cryptfile();
            Cezar cezar = new Cezar();
            cryptfile.cryptfile(input_name,output_name,cezar, rotacja);
    }
}
