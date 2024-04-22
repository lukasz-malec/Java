package cwiczenie5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFile {
    public static String fileToString(String path_to_file_in) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path_to_file_in)));
    }

    public static void StringToFile (String path_to_file, String content) throws IOException {
        Files.write(Paths.get(path_to_file), content.getBytes());
    }
}