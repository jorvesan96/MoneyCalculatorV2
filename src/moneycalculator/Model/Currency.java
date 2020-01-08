package moneycalculator.Model;

public class Currency {
    
    private final String isoCode;
    private final String name;
    private final String symbol;

    public Currency(String isoCode, String name, String symbol) {
        this.isoCode = isoCode;
        this.name = name;
        this.symbol = symbol;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString(){
        return isoCode;
    }

}
