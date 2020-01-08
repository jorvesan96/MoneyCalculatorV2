package moneycalculator.Loaders.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import moneycalculator.Model.Currency;
import moneycalculator.Model.ExchangeRate;
import moneycalculator.Loaders.ExchangeRateLoader;

public class RestExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getIsoCode(), to.getIsoCode()));
        } catch (IOException ex) {
            return null;
        }
    }

    private double read(String from, String to) throws IOException {
        String line = read(new URL("http://api.fixer.io/latest?base="+from+"&symbols"+to));
        return Double.parseDouble(line.substring(line.indexOf(to)+5, line.indexOf("}")));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int lenght = is.read(buffer);
        return new String(buffer, 0, lenght);
    }
}