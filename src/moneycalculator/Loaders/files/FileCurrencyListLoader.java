/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator.Loaders.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculator.Model.Currency;
import moneycalculator.Loaders.CurrencyListLoader;

public class FileCurrencyListLoader implements CurrencyListLoader{
    private final String filename;

    public FileCurrencyListLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public Currency[] currencies() {
        List<Currency>list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            while(true){
                String line = reader.readLine();
                if(line == null)break;
                list.add(currencyOf(line));
            }
        } catch (FileNotFoundException ex) {     
        } catch (IOException ex) {
           
        }
        return list.toArray(new Currency[0]);
    }

    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }

}
