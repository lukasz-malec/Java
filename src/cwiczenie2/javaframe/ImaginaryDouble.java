package cwiczenie2.javaframe;


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
        String[] idk = new String[3];

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
            result.value = (Double) this.value + (Integer) (v.value);
            result.imDouble = this.imDouble + ((ImaginaryInt) v).imInt;
            return result;
        } else if (v instanceof Int) {
            result.value = (Double) this.value + (Double) (v.value);
            result.imDouble = this.imDouble;
            return result;
        }
        else{
            result.value = (Double) this.value + Double.valueOf(v.value.toString());
            result.imDouble = this.imDouble;
            return result;
        }
    }
}