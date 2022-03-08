package concepts;

//Immutable class: all variables are declared final and with readonly methods.
/*
* If we need to share state between different threads, we can create thread-safe classes by making them immutable
* a class instance is immutable when its internal state can't be modified after it has been constructed.
* The easiest way to create an immutable class in Java is by declaring all the fields private and final and not providing setters:
* */
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

