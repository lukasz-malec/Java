package cwiczenie7;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int portNumber;

        // Losuj dostępny port

        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException e) {
            System.out.println("Port " +   " is already in use. Trying another port...");
        }


        System.out.println(serverSocket.getLocalPort());  // Wypisz numer portu na standardowe wyjście błędów

        while(true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
            } catch (IOException e) {
                System.out.println("Accept failed on port: ");
                System.exit(-1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String result = evaluateMathExpression(inputLine);
                out.println(result);
            }
            out.close();
            in.close();
            clientSocket.close();
        }


        //serverSocket.close();
    }

    private static String evaluateMathExpression(String expression) {
        String[] tokens = expression.split("(?<=\\d)(?=\\D)|(?<=\\d[-+*/])");
        double result = 0;
        char operation = '+';

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                operation = token.charAt(0);
            } else {
                // Handle negative numbers correctly
                if (token.isEmpty()) continue;

                double value = Double.parseDouble(token);
                switch (operation) {
                    case '+':
                        result += value;
                        break;
                    case '-':
                        result -= value;
                        break;
                    case '*':
                        result *= value;
                        break;
                    case '/':
                        if (value == 0) return "Division by zero ersror";
                        result /= value;
                        break;
                }
            }
        }

        // Check if the result is an integer to format output accordingly
        return (result % 1 == 0) ? String.format("%d", (int)result) : String.format("%s", result);
    }
}
