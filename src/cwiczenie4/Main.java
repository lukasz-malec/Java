package cwiczenie4;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java Main <input_file> <output_file> <crypt/decrypt> <rot/polibiusz>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];
        String operation = args[2];
        String algorithmType = args[3];

        Algorithm algorithm;
        if (algorithmType.equals("rot")) {
            algorithm = new ROTXX();
        } else if (algorithmType.equals("polibiusz")) {
            algorithm = new Polibiusz();
        } else {
            System.out.println("Invalid algorithm type");
            return;
        }

        if (operation.equals("crypt")) {
            Cryptographer.cryptfile(inputFilePath, outputFilePath, algorithm);
        } else if (operation.equals("decrypt")) {
            Cryptographer.decryptfile(inputFilePath, outputFilePath, algorithm);
        } else {
            System.out.println("Invalid operation");
        }
    }
}

