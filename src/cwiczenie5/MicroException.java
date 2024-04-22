package cwiczenie5;

public class MicroException extends Exception {

    final private String message;

    final private int errorLine;

    public MicroException (String message, int errorLine) {
        this.message = message;
        this.errorLine = errorLine;
    }
    public String getMessage () {
        return this.message;
    }

    public int getErrorLine () {
        return this.errorLine;
    }
}