package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MoneyCalculator {
    
    private double amount;
    private double exchangeRate;
    private String currencyFrom;
    private String currencyTo;

    public static void main(String[] args) throws Exception{
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        moneyCalculator.execute();
    }
    
    private void execute() throws Exception{
        input();
        process();
        output();
        
    }
    
    private void input(){
        System.out.println("Introduzca una cantidad: ");
        Scanner scanner = new Scanner(System.in);
        
        amount = Double.parseDouble(scanner.next());
        
        System.out.println("Introduzca una divisa origen: ");
        currencyFrom = scanner.next();
        
        System.out.println("Introduzca una divisa destino: ");
        currencyTo = scanner.next();
    }
    
    private void process() throws Exception{
        exchangeRate = getExchangeRate(currencyFrom,currencyTo);
    }
    
    private void output() {
        System.out.println(amount + " " + currencyFrom + " equivalen a " + amount * exchangeRate + " " + currencyTo);
    }
    
    private static double getExchangeRate(String from, String to) throws Exception {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                   from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to)+12, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }    
}
