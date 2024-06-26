package cwiczenie2.javaframe;

public class MyDataFrame extends DataFrame{
    public MyDataFrame(Class<? extends Value>[] types, String[] vals){
        super(types,vals);
    }

    public void print(){
        for (int j = 0; j < columns.size(); j++) {
            System.out.print(columns.get(j).name + "\t");
        }
        System.out.println();
        for(int i = 0; i < columns.get(0).values.size();i++){
            for(int j = 0; j <columns.size();j++){
                System.out.print(columns.get(j).values.get(i).toString());
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
