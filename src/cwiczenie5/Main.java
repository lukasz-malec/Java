package cwiczenie5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Incorrect parameters");
            return;
        }
        String inputFile = args[0];
        String outputFile = args[1];
        int delay;
        try {
            delay = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("delay must be int ");
            return;
        }
        int fps;
        try {
            fps = Integer.parseInt(args[3]);
        }
        catch (NumberFormatException e) {
            System.out.println("fps must be int");
            return;
        }
        String inputString;
        try {
            inputString = MyFile.fileToString(inputFile);
        }
        catch (IOException e) {
            System.out.println("Cannot open input file " + inputFile);
            return;
        }
        String outputString = "";
        try {
            outputString = MicroDVDDelay.delay(inputString, delay, fps);
        }
        catch (MicroException e) {
            //System.out.println(e.getMessage());
            System.out.println(e.getErrorLine());
        }
        try {
            MyFile.StringToFile(outputFile, outputString);
        }
        catch (IOException e) {
            System.out.println("Cannot open output file " + outputFile);
        }
    }
}
