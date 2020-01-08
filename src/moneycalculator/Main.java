package moneycalculator;

import moneycalculator.Control.CalculateCommand;
import moneycalculator.Loaders.CurrencyListLoader;
import moneycalculator.Loaders.ExchangeRateLoader;
import moneycalculator.Loaders.RestExchangeRateLoader;
import moneycalculator.Loaders.files.FileCurrencyListLoader;


public class Main {

   
    public static void main(String[] args) {
        CurrencyListLoader currencyloader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyloader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
}