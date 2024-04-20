package ObslugaI0_Strumienie.Cezar;

public class Cezar {
    public String alfabeth = "ABCDEFGHIJKLMNOPRSTUWXYZabcdefghijklmnoprstuwxyz";

    public char[] cryptCezar(String słowo, int rotacja){
        char znaki[] = new char[słowo.length()];
        for(int i = 0; i < słowo.length();i++){
            znaki[i] = słowo.charAt(i);
            int index = alfabeth.indexOf(znaki[i]);

            int newindex = index + rotacja % alfabeth.length();
            if (newindex < 0) {
                newindex += alfabeth.length();
            }
            if (newindex > alfabeth.length()-1) {
                newindex -= alfabeth.length();
            }

            znaki[i] = alfabeth.charAt(newindex);
        }
        return znaki;
    }
}
