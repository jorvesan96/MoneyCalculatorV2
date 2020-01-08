package moneycalculator.View.swing;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import moneycalculator.Model.Currency;
import moneycalculator.Model.Money;
import moneycalculator.View.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog{
    private Currency currency;
    private String amount;
    private final Currency[] currencies;

    public SwingMoneyDialog(Currency[] currencies) {
        this.add(amount());
        this.add(currency());
        this.currencies = currencies;
    }

    @Override
    public Money get() {
        return new Money(Double.parseDouble(amount), currency);
    }

    private Component amount() {
        JTextField textField = new JTextField("100");
        textField.setColumns(10);
        textField.getDocument().addDocumentListener(amountChanged());
        return textField;
    }

    private Component currency() {
        JComboBox combo = new JComboBox(currencies);
        combo.addItemListener(currencyChanged());
        currency = (Currency)combo.getSelectedItem();
        return combo;
    }

    /*private Currency[] currencies() {
        return new Currency[]{
            new Currency("USD", "Dollar", "$"),
            new Currency("CAD", "Dollar Canada", "C$"),
            new Currency("GBP", "Libra esterlina", "£"),
        };
    }*/

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED)return;
                currency = (Currency)e.getItem();
                
            }
        };
        
    }

    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                amuntChanged(e.getDocument());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                amuntChanged(e.getDocument());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                amuntChanged(e.getDocument());
            }

            private void amuntChanged(Document document) {
                try {
                    amount = document.getText(0, document.getLength());
                } catch (BadLocationException ex) {
                   
                }
                
            }
        };
    }
    
}