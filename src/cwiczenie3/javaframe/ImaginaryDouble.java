package cwiczenie3.javaframe;

import java.util.Objects;

public class ImaginaryDouble extends MyDouble{
    public Double imDouble = 0.0;

    @Override
    public Value create(String val) {
        ImaginaryDouble v = new ImaginaryDouble();
        String[] parts = new String[3];

        int index = val.indexOf("i");

        if (index != -1) {
            parts[0] = val.substring(0, index);
            parts[1] = "i";
            parts[2] = val.substring(index + 1);
            v.value = Double.parseDouble(parts[0]);
            v.imDouble = Double.parseDouble(parts[2]);
        } else {
            v.value = Double.parseDouble(val);
        }
        return v;
    }

    @Override
    public String toString() {
        ImaginaryDouble v = new ImaginaryDouble();
        //[] idk = new String[3];

        String jeden = value.toString();
        String dwa = imDouble.toString();
        String wynik = jeden +"i"+ dwa;
        return wynik;
    }


    @Override
    public Value add(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();

        if (v instanceof ImaginaryDouble) {
            result.value = (Double) this.value + (Double) (v.value);
            result.imDouble = this.imDouble + ((ImaginaryDouble) v).imDouble;
            return result;
        } else if (v instanceof ImaginaryInt) {
            result.imDouble = this.imDouble + ((ImaginaryInt) v).imInt;
            result.value = (Double) this.value + (Integer) v.value;
            return result;
        } else if (v instanceof Int) {
            result.value = (Double) this.value + (Integer) (v.value);
            result.imDouble = this.imDouble;
            return result;
        }
        else{
            result.value = (Double) this.value + Double.parseDouble(v.value.toString());
            result.imDouble = this.imDouble;
            return result;
        }
    }

    @Override
    public Value sub(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();

        if (v instanceof ImaginaryDouble) {
            result.value = (Double) this.value - (Double) (v.value);
            result.imDouble = this.imDouble - ((ImaginaryDouble) v).imDouble;
            return result;
        } else if (v instanceof ImaginaryInt) {
            result.value = (Double) this.value - (Integer) (v.value);
            result.imDouble = this.imDouble - ((ImaginaryInt) v).imInt;
            return result;
        } else if (v instanceof Int) {
            result.value = (double) ((Double) this.value - (Integer) (v.value));
            result.imDouble = this.imDouble;
            return result;
        }
        else{
            result.value = (Double) this.value - Double.parseDouble(v.value.toString());
            result.imDouble = this.imDouble;
            return result;
        }
    }


    @Override
    public Value mul(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();

        if(v instanceof ImaginaryDouble){
            result.value = (Double) this.value * (Double)(v.value) + this.imDouble * ((ImaginaryDouble)v).imDouble * -1;
            result.imDouble = this.imDouble * (Double)(v.value) + (Double)this.value * ((ImaginaryDouble)v).imDouble;
            return result;
        }else if (v instanceof ImaginaryInt){
            result.value = (Double) this.value * (Integer)(v.value) + this.imDouble * ((ImaginaryInt)v).imInt * -1;
            result.imDouble = this.imDouble * (Integer)(v.value) + (Double)this.value * ((ImaginaryInt)v).imInt;
            return result;
        }else if (v instanceof Int){
            result.value = (Double) this.value * (Integer) (v.value);
            result.imDouble = this.imDouble *(Integer) v.value;
            return result;
        }else{
            result.value = (Double) this.value * Double.parseDouble(v.value.toString());
            result.imDouble = this.imDouble * Double.parseDouble(v.value.toString());
            return result;
        }
    }

    @Override
    public Value div(Value v) {
        ImaginaryDouble result = new ImaginaryDouble();

        if (v instanceof ImaginaryDouble) {
            ((ImaginaryDouble) v).imDouble = ((ImaginaryDouble) v).imDouble *-1;
            ImaginaryDouble mianownikDo2 = new ImaginaryDouble();
            mianownikDo2.imDouble = (((ImaginaryDouble) v).imDouble * ((ImaginaryDouble) v).imDouble) + ((Double)v.value * (Double) v.value);
            result.value = ((Double) this.value * (Double)(v.value) + this.imDouble * ((ImaginaryDouble)v).imDouble * -1) /mianownikDo2.imDouble;
            result.imDouble = (this.imDouble * (Double)(v.value) + (Double)this.value * ((ImaginaryDouble)v).imDouble )/ mianownikDo2.imDouble;
            return result;
        } else if (v instanceof ImaginaryInt) {
            ((ImaginaryInt) v).imInt = ((ImaginaryInt) v).imInt *-1;
            ImaginaryDouble mianownikDo2 = new ImaginaryDouble();
            mianownikDo2.imDouble = (double) (((ImaginaryInt) v).imInt * ((ImaginaryInt) v).imInt) + ((Integer) v.value * (Integer) v.value);
            result.value = ((Double) this.value * (Integer)(v.value) + this.imDouble * ((ImaginaryInt)v).imInt * -1) /mianownikDo2.imDouble;
            result.imDouble = (this.imDouble * (Integer)(v.value) + (Double)this.value * ((ImaginaryInt)v).imInt )/ mianownikDo2.imDouble;
            return result;
        } else if (v instanceof Int) {
            result.value = (Double) this.value / (Integer) (v.value);
            result.imDouble = this.imDouble / (Integer) v.value;
            return result;
        } else{
            result.value = (Double) this.value / Double.parseDouble(v.value.toString());
            result.imDouble = this.imDouble / Double.parseDouble(v.value.toString());
            return result;
        }
    }


    @Override
    public boolean eq(Value v){
        if (v instanceof ImaginaryDouble){
            if((this.value.equals((Double)v.value) && this.imDouble.equals(((ImaginaryDouble) v).imDouble))){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if (v instanceof ImaginaryDouble){
            if((this.value.equals((Double)v.value) && this.imDouble.equals(((ImaginaryDouble) v).imDouble))){
                return false;
            }
        }
        return true;
    }
    public  boolean equals(Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        ImaginaryDouble dbIM = (ImaginaryDouble) other;
        return (this.value == dbIM.value && dbIM.imDouble == this.imDouble) ;
    }
    @Override
    public int hashCode() {
        return Objects.hash(value,imDouble);
    }

    @Override
    public Value pow(Value v) {
        MyDouble result = new MyDouble();

        if (this.value != null) {
            double thisValue = (Double) this.value;
            if (v instanceof MyDouble) {
                double otherValue = (Double) v.value;
                double wynik = Math.pow(thisValue, otherValue);
                result.value = wynik;
                return result;
            } else {
                int otherValue = (Integer) v.value;
                double wynik = Math.pow(thisValue, otherValue);
                result.value = wynik;
                return result;
            }
        }else{
            return null;
        }
    }
}
