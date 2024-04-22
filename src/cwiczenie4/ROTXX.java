package cwiczenie4;

public class ROTXX implements Algorithm {
    private final String alphabet;
    private final int rotation;

    public ROTXX() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        this.rotation = 11;
    }

    public ROTXX(String alphabet, int rotation) {
        this.alphabet = alphabet;
        this.rotation = rotation % alphabet.length();
    }

    @Override
    public String crypt(String inputWord) {
        StringBuilder result = new StringBuilder();
        for (char c : inputWord.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                int newIndex = (index + rotation) % alphabet.length();
                if (newIndex < 0) {
                    newIndex += alphabet.length();
                }
                result.append(alphabet.charAt(newIndex));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String inputWord) {
        ROTXX decryptor = new ROTXX(alphabet, alphabet.length() - rotation);
        return decryptor.crypt(inputWord);
    }
}
