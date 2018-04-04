package com.example.java;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        double doubleValue = 1_234_567.89;

        //Format number for current locale
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        System.out.println(numberFormat.format(doubleValue));

        //Format int for current locale
        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        System.out.println(intFormat.format(doubleValue));

        //Modify certain characteristics of the output explicitly
        numberFormat.setGroupingUsed(false);
        System.out.println(numberFormat.format(doubleValue));

        //Specifically format the number for German in Germany.
        Locale locale = new Locale("de", "DE");
        NumberFormat localFormat = NumberFormat.getNumberInstance(locale);
        System.out.println(numberFormat.format(doubleValue));

        //Format as currency for current locale
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println(currencyFormat.format(doubleValue));

        //Format as currency for the german locale from above
        NumberFormat germanCurrencyFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(germanCurrencyFormat.format(doubleValue));

        //Explicitly define the structure of the output
        DecimalFormat df = new DecimalFormat("$000.00"); //Use # to only include position if necessary
        System.out.println(df.format(1));
        System.out.println(df.format(5.891));
    }
}
