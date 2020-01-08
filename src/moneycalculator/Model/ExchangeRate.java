package moneycalculator.Model;

public class ExchangeRate {
    private final Currency to;
     private final Currency from;
     private final double amount;

    public Currency getTo() {
        return to;
    }

    public Currency getFrom() {
        return from;
    }

    public double getAmount() {
        return amount;
    }

    public ExchangeRate(Currency to, Currency from, double amount) {
        this.to = to;
        this.from = from;
        this.amount = amount;
    }
    
}