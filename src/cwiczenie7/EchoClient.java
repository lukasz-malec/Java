package cwiczenie7;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java EchoClient <serverPort> <expression>");
            System.exit(1);
        }

        int serverPort = Integer.parseInt(args[0]);
        String expression = args[1];

        // Utwórz nowy socket dla komunikacji z serwerem
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", serverPort);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: localhost.");
            System.exit(1);
        }

        // Wysyłanie wyrażenia matematycznego do serwera
        out.println(expression);

        String result = in.readLine();
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No result received from the server.");
        }


        // Zamknij połączenie
        out.close();
        in.close();
        echoSocket.close();
    }
}


