package cwiczenie6.javaframe;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Series {
    ArrayList<Value> values = new ArrayList<>();
    String name;
    Class<? extends Value> type;

    public Series(Class type,String name ){
        this.name = name;
        this.type = type;
    }

    public void addValue(String value){
        try {
            values.add(type.getDeclaredConstructor().newInstance().create(value));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public Series iloc(int from, int to){
        Series result = new Series(type, name);
        for(int i=from;i<to&&i<this.values.size();i++){
            result.addValue(this.values.get(i).toString());
        }
        return result;
    }

    public Value get(int index) {
        if (index >= 0 && index < values.size()) {
            return values.get(index);
        } else {
            // Handle the case when the index is out of bounds
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for Series with size " + values.size());
        }
    }

}

