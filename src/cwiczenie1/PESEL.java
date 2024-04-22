package cwiczenie1;


public class PESEL {
    public PESEL(String PESEL){
        this.PESEL = PESEL;
    }
    String PESEL;


    public void compare(PESEL obj1, PESEL obj2){
        if( obj1.PESEL.equals(obj2.PESEL)){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }

    public static boolean poprawnosc = true;

    public static void check(PESEL obj1){
        if(obj1.PESEL.length() != 11 ){
            //System.out.println(0);
            poprawnosc = false;
        } else{

            int suma = 0;
            int[] waga = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

            for(int j = 0; j < 10 ;j++){
                suma += Character.getNumericValue(obj1.PESEL.charAt(j))* waga[j];
            }

            int liczbaKontrolna = 10 - (suma % 10);

            if (liczbaKontrolna == 10) {
                liczbaKontrolna = 0;
            }

            if (liczbaKontrolna == Character.getNumericValue(obj1.PESEL.charAt(10))) {
                //System.out.println(1);
            } else {
                // System.out.println(0);
                poprawnosc = false;
            }
        }
    }

}
