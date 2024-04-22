package cwiczenie4;

public class Polibiusz implements Algorithm {

    private final char[][] arr;
    private String alphabet;

    public Polibiusz() {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", 7);
    }

    public Polibiusz(String alphabet, int size) {
        StringBuilder alphabetBuilder = new StringBuilder(alphabet);
        if (size * size < alphabet.length()) {
            alphabetBuilder.setLength(size * size);
        } else {
            while (alphabetBuilder.length() < size * size) {
                alphabetBuilder.append(" ");
            }
        }
        this.alphabet = alphabetBuilder.toString();

        arr = new char[size][size];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = this.alphabet.charAt(index++);
            }
        }
    }

    @Override
    public String crypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        for (char c : inputWord.toCharArray()) {
            boolean f = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == c) {
                        result.append(i + 1).append(j + 1).append(' ');
                        f = true;
                        break;
                    }
                }
                if (f) {
                    break;
                }
            }
        }
        return result.toString().trim();
    }


    @Override
    public String decrypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        for (int n = 0; n < inputWord.length() - 1; n += 2) {
            char a = inputWord.charAt(n);
            char b = inputWord.charAt(n + 1);

            if (a == ' ') {
                n--;
            } else if (b == ' ') {
                break;
            } else if (Character.isDigit(a) && Character.isDigit(b)) {
                int row = Character.getNumericValue(a) - 1;
                int col = Character.getNumericValue(b) - 1;
                result.append(arr[row][col]);
            }
        }
        return result.toString();
    }
}
