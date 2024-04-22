package cwiczenie4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Cryptographer{

    public static void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path_to_file_in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path_to_file_out))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    writer.write(algorithm.crypt(word) + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path_to_file_in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(path_to_file_out))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    writer.write(algorithm.decrypt(word));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
