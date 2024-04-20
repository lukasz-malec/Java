package ObslugaI0_Strumienie.Cezar;
import java.io.*;

public class Cryptfile {
    public void cryptfile(String input_path, String output_path, Cezar cezar, int rotacja) throws IOException {

        BufferedReader in = null;
        BufferedWriter out = null;
        try{
             in = new BufferedReader(new FileReader(input_path));
             out = new BufferedWriter(new FileWriter(output_path));

             String line;

             while((line = in.readLine()) != null){
                 String []words = line.split("\\s");
                 for(String elem : words){
                     out.write(cezar.cryptCezar(elem,1));
                 }
             }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if( in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}

