package cwiczenie2.javaframe;

public class ImaginaryInt extends Int{
    public Integer imInt= 0;

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
        String wynik = jeden +"i"+ dwa;
        return wynik;
    }

    @Override
    public Value add(Value v) {
        ImaginaryInt result  = new ImaginaryInt();

        if(v instanceof ImaginaryDouble) {
            result.value = (Integer) this.value + ((Double)(v.value)).intValue();
            result.imInt = this.imInt + ((((ImaginaryDouble)v).imDouble)).intValue();
            return result;
        } else if(v instanceof ImaginaryInt) {
            result.value = (Integer) this.value + (Integer) (v.value);
            result.imInt = this.imInt + ((ImaginaryInt) v).imInt;
            return result;
        } else if(v instanceof Int) {
            result.value = (Integer) this.value + (Integer) (v.value);
            result.imInt = this.imInt;
            return result;
        }else{
            result.value = (Integer) this.value + Double.parseDouble(v.value.toString());
            return result;
        }


    }

}
