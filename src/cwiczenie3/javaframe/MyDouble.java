package cwiczenie3.javaframe;


import java.util.Objects;

public class MyDouble extends Value {
    @Override
    public Value create(String val) {
        MyDouble v = new MyDouble();
        v.value = Double.parseDouble(val);
        return v;
    }

    @Override
    public Value add(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value + Double.valueOf(v.value.toString());
        return result;

    }

    @Override
    public Value sub(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value - Double.valueOf(v.value.toString());
        return result;
    }


    @Override
    public Value mul(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value * Double.valueOf(v.value.toString());
        return result;

    }
    @Override
    public Value div(Value v) {
        MyDouble result  = new MyDouble();
        result.value = (Double)this.value / Double.valueOf(v.value.toString());
        return result;
    }


    @Override
    public  Value pow(Value v){
        MyDouble result = new MyDouble();
        if (v instanceof MyDouble) {
            double thisValue = (Double) this.value;
            double otherValue = (Double) v.value;
            double wynik = Math.pow(thisValue, otherValue);
            result.value = wynik;
            return result;
        }else{
            double thisValue = (Double) this.value;
            int otherValue = (Integer) v.value;
            result.value = Math.pow(thisValue, otherValue);
            return result;
        }
    }
    @Override
    public boolean eq(Value v){
        if (v instanceof MyDouble && !(v instanceof ImaginaryDouble)){
            return this.value.equals((Double)v.value);
        }
        return false;
    }

    @Override
    public boolean lte(Value v) {
        if (v instanceof MyDouble && !(v instanceof ImaginaryDouble)) {
            return (Double)this.value <= ((Double)v.value);
        }else if(v instanceof Int && !(v instanceof  ImaginaryInt)) {
            return (Double) this.value <= ((Integer) v.value);
        }
        return false;
    }

    @Override
    public boolean gte(Value v) {
        if (v instanceof MyDouble && !(v instanceof ImaginaryDouble)) {
            return (Double)this.value >= ((Double)v.value);
        }else if(v instanceof Int && !(v instanceof  ImaginaryInt)) {
            return (Double) this.value >= ((Integer) v.value);
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if (v instanceof MyDouble && !(v instanceof ImaginaryDouble)){
            return !this.value.equals((Double)v.value);
        }
        return true;
    }

    @Override
    public  boolean equals(Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        MyDouble db = (MyDouble) other;
        return this.value == db.value;

    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

