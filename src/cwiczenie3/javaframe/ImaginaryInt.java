package cwiczenie3.javaframe;

import java.util.Objects;

public class ImaginaryInt extends Int {
    public Integer imInt = 0;

    @Override
    public Value create(String val) {
        ImaginaryInt v = new ImaginaryInt();
        String[] parts = new String[3];

        int index = val.indexOf("i");

        if (index != -1) {
            parts[0] = val.substring(0, index);
            parts[1] = "i";
            parts[2] = val.substring(index + 1);
            v.value = Integer.parseInt(parts[0]);
            v.imInt = Integer.parseInt(parts[2]);
        } else {
            v.value = Integer.parseInt(val);
        }
        return v;
    }

    @Override
    public String toString() {
        ImaginaryInt v = new ImaginaryInt();
        String[] idk = new String[3];

        String jeden = value.toString();
        String dwa = imInt.toString();
        String wynik = jeden + "i" + dwa;
        return wynik;
    }

    @Override
    public Value add(Value v) {
        ImaginaryInt result = new ImaginaryInt();

        if (v instanceof ImaginaryDouble) {
            result.value = (Integer) this.value + ((Double) (v.value)).intValue();
            result.imInt = this.imInt + ((((ImaginaryDouble) v).imDouble)).intValue();
            return result;
        } else if (v instanceof ImaginaryInt) {
            result.value = (Integer) this.value + (Integer) (v.value);
            result.imInt = this.imInt + ((ImaginaryInt) v).imInt;
            return result;
        } else if (v instanceof Int) {
            result.value = (Integer) this.value + (Integer) (v.value);
            result.imInt = this.imInt;
            return result;
        } else {
            result.value = (Integer) this.value + Double.valueOf(v.value.toString()).intValue();
            return result;
        }
    }

    @Override
    public Value sub(Value v) {
        ImaginaryInt result = new ImaginaryInt();

        if (v instanceof ImaginaryDouble) {
            result.value = (Integer) this.value - ((Double) (v.value)).intValue();
            result.imInt = this.imInt - ((((ImaginaryDouble) v).imDouble)).intValue();
            return result;
        } else if (v instanceof ImaginaryInt) {
            result.value = (Integer) this.value - (Integer) (v.value);
            result.imInt = this.imInt - ((ImaginaryInt) v).imInt;
            return result;
        } else if (v instanceof Int) {
            result.value = (Integer) this.value - (Integer) (v.value);
            result.imInt = this.imInt;
            return result;
        } else {
            result.value = (Integer) this.value - Double.valueOf(v.value.toString()).intValue();
            return result;
        }
    }


    @Override
    public Value mul(Value v) {
        ImaginaryInt result = new ImaginaryInt();

        if (v instanceof ImaginaryDouble) {
            result.value = (int)((Integer) this.value * (Double)(v.value) + this.imInt * ((ImaginaryDouble)v).imDouble * -1.0);
            result.imInt = (int) (this.imInt * (Double)v.value + (Integer)this.value * ((ImaginaryDouble) v).imDouble);
            return result;
        } else if (v instanceof ImaginaryInt) {
            result.value = (Integer) this.value * (Integer)(v.value) + this.imInt * ((ImaginaryInt)v).imInt * -1;
            result.imInt = this.imInt * (Integer)(v.value) + (Integer) this.value * ((ImaginaryInt)v).imInt;
            return result;
        } else if (v instanceof Int) {
            result.value = (Integer) this.value * (Integer) (v.value);
            result.imInt= this.imInt *(Integer) v.value;
            return result;
        } else{
            result.value = (int) ((Integer) this.value * Double.parseDouble(v.value.toString()));
            result.imInt = (int) (this.imInt * Double.parseDouble(v.value.toString()));
            return result;
        }
    }

    @Override
    public Value div(Value v) {
        ImaginaryInt result = new ImaginaryInt();

        if (v instanceof ImaginaryDouble) {
            ((ImaginaryDouble) v).imDouble = ((ImaginaryDouble) v).imDouble *-1;
            ImaginaryDouble mianownikDo2 = new ImaginaryDouble();
            mianownikDo2.imDouble = (((ImaginaryDouble) v).imDouble * ((ImaginaryDouble) v).imDouble) + ((Double)v.value * (Double) v.value);
            result.value = (int)(((Integer) this.value * (Double)(v.value) + this.imInt * ((ImaginaryDouble)v).imDouble * -1) /mianownikDo2.imDouble);
            result.imInt = (int)((this.imInt * (Double) (v.value) + (Integer)this.value * ((ImaginaryDouble)v).imDouble )/ mianownikDo2.imDouble);
            return result;
        } else if (v instanceof ImaginaryInt) {
            ((ImaginaryInt) v).imInt = ((ImaginaryInt) v).imInt *-1;
            ImaginaryInt mianownikDo2 = new ImaginaryInt();
            mianownikDo2.imInt = (((ImaginaryInt) v).imInt * ((ImaginaryInt) v).imInt) + ((Integer) v.value * (Integer) v.value);
            result.value = (((Integer) this.value * (Integer) (v.value) + this.imInt * ((ImaginaryInt)v).imInt * -1) /mianownikDo2.imInt);
            result.imInt = ((this.imInt * (Integer) (v.value) + (Integer)this.value * ((ImaginaryInt)v).imInt )/ mianownikDo2.imInt);
            return result;
        } else if (v instanceof Int) {
            result.value = (Integer) this.value / (Integer) (v.value);
            result.imInt= this.imInt /(Integer) v.value;
            return result;
        } else{
            result.value =(int) ((Integer) this.value / Double.parseDouble(v.value.toString()));
            result.imInt =(int) (this.imInt /(Double) v.value);
            return result;
        }
    }

    @Override
    public boolean eq(Value v){
        if (v instanceof ImaginaryInt){
            if((this.value.equals((Integer)v.value) && this.imInt.equals(((ImaginaryInt) v).imInt))){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean neq(Value v){
        if (v instanceof ImaginaryInt){
            if((this.value.equals((Integer)v.value) && this.imInt.equals(((ImaginaryInt) v).imInt))){
                return false;
            }
        }
        return true;
    }

    public  boolean equals(Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        ImaginaryInt intIm = (ImaginaryInt) other;
        return (this.value == intIm.value && intIm.imInt == this.imInt) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, imInt);
    }
}