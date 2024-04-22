package cwiczenie2;

import java.util.HashSet;
import java.io.IOException;
import java.util.function.Consumer;
 import cwiczenie2.javaframe.*;

public class Main {

    public static void main(String[] args) {

         MyDataFrame df = new MyDataFrame(new Class[] {ImaginaryDouble.class, Int.class}, new String[] {"kol1","kol2"});

         df.addRow(new String[]{"12i3","23"});
         df.addRow(new String[]{"1244i4","23"});
         df.addRow(new String[]{"1244i6","2553"});
         df.addRow(new String[]{"12i9","2300"});

         ImaginaryDouble im1 = (ImaginaryDouble) new ImaginaryDouble().create("12i3");
         ImaginaryDouble im2 = (ImaginaryDouble) new ImaginaryDouble().create("5i3");
         ImaginaryDouble im3 = (ImaginaryDouble) new ImaginaryDouble().create("5");
         MyDouble re = (MyDouble) new MyDouble().create("5");

         im1.print();
         System.out.println();
         im2.print();
         System.out.println();
         re.add(im2).print();
         System.out.println();
         System.out.println("------------------------------");
         df.print();

    }

}
