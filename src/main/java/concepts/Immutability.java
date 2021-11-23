package concepts;

//Immutable class: all variables are declared final and with readonly methods.
public class Immutability {
    private final double rate;
    private final String rateType;
    private final CurrencyPair ccyPair;
    public Immutability(double rate, String rateType, CurrencyPair ccyPair){
        this.rate = rate;
        this.rateType = rateType;
        this.ccyPair = ccyPair;
    }

    public double getRate() {
        return rate;
    }

    public String getRateType() {
        return rateType;
    }

    public CurrencyPair getCcyPair(){
        return ccyPair;
    }
}
//Immutable class: all variables are declared final and with readonly methods.
class CurrencyPair{
    private final String fromCcy;
    private final String toCcy;
    public CurrencyPair(String fromCcy, String toCcy){
        this.fromCcy = fromCcy;
        this.toCcy = toCcy;
    }

    public String getFromCcy(){
        return fromCcy;
    }
    public String getToCcy(){
        return toCcy;
    }
}

