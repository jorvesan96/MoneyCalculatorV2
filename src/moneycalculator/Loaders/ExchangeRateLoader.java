package moneycalculator.Loaders;

import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}