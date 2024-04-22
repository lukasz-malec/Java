package cwiczenie3.javaframe;


import java.util.Objects;

public class Int extends Value{
    @Override
    public Value create(String val) {
        Int v = new Int();
        v.value = Integer.parseInt(val);
        return v;
    }

    @Override
    public Value add(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value + (Integer)v.value;
        }else{
            result.value = (Integer)this.value + Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public Value sub(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value - (Integer)v.value;
        }else{
            result.value = (Integer)this.value - Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public Value mul(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value * (Integer)v.value;
        }else{
            result.value = (Integer)this.value * Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public Value div(Value v) {

        Int result  = new Int();
        if(v.value instanceof Integer){
            result.value = (Integer)this.value / (Integer)v.value;
        }else{
            result.value = (Integer)this.value / Double.valueOf(v.value.toString()).intValue();
        }
        return result;
    }

    @Override
    public  Value pow(Value v){
        Int result = new Int();
        if (v instanceof Int) {
            int thisValue = (Integer) this.value;
            int otherValue = (Integer) v.value;
            int wynik = (int) (Math.pow(thisValue, otherValue));
            result.value = wynik;
            return result;
        }else{
            int thisValue = (Integer) this.value;
            double otherValue = (Double) v.value;
            result.value = (int) (Math.pow(thisValue, otherValue));
            return result;
        }
    }
    @Override
    public boolean eq(Value v){
        if (v instanceof Int && !(v instanceof ImaginaryInt)){
            return this.value.equals((Integer)v.value);
        }
        return false;
    }

    @Override
    public boolean lte(Value v) {
        if (v instanceof Int && !(v instanceof ImaginaryInt)) {
            return (Integer)this.value <= ((Integer)v.value);
        }else if(v instanceof MyDouble && !(v instanceof  ImaginaryDouble)) {
            return (Integer) this.value <= ((Double) v.value);
        }
        return false;
    }

    @Override
    public boolean gte(Value v) {
        if (v instanceof Int && !(v instanceof ImaginaryInt)) {
            return (Integer)this.value >= ((Integer)v.value);
        }else if(v instanceof MyDouble && !(v instanceof  ImaginaryDouble)) {
            return (Integer) this.value >= ((Double) v.value);
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if (v instanceof Int && !(v instanceof ImaginaryInt)){
            return !this.value.equals((Integer)v.value);
        }
        return true;
    }

    @Override
    public  boolean equals(Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Int myInt = (Int) other;
        return this.value == myInt.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
