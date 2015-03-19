package com.twu.refactor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dollyg on 3/17/2015.
 */
public class Statement {
    private String customerName;
    private final Map<String, Double> rentalSubTotal;
    private double amount;
    private int frequentRenterPoints;

    public Statement(String customerName, Map<String, Double> rentalSubTotal, double amount, int frequentRenterPoints) {

        this.customerName = customerName;
        this.rentalSubTotal = rentalSubTotal;
        this.amount = amount;
        this.frequentRenterPoints = frequentRenterPoints;
    }


    @Override
    public String toString() {
        String textStatement = "Rental Record for #{customerName}\n#{rentalSummary}" +
                "Amount owed is #{amount}\nYou earned #{frequentRenterPoints} frequent renter" +
                " points";
        String rentalSummaryTemplate = "\t#{movie}\t#{amount}\n";
        String rentalSummary = "";
        textStatement = textStatement.replace("#{customerName}",customerName);
        for (String movie : rentalSubTotal.keySet()){
            rentalSummary += rentalSummaryTemplate.replace("#{movie}",movie).replace("#{amount}",rentalSubTotal.get(movie)+"");
        }
        textStatement = textStatement.replace("#{rentalSummary}",rentalSummary);
        textStatement = textStatement.replace("#{amount}",amount+"").replace("#{frequentRenterPoints}",frequentRenterPoints+"");
        return textStatement;
    }

    public String toHTML() {
        String statement = "<H1>Rentals for <EM>" + customerName + "</EM></H1><P>";
        for (String movie : rentalSubTotal.keySet()){
            statement += movie + ": " + rentalSubTotal.get(movie) + "<BR>";
        }
        statement += "<P>" + "You owe <EM>" + amount + "</EM>" +
            "<P>On this rental you earned <EM>" + frequentRenterPoints +
            "</EM> frequent renter points<P>";
        return statement;
    }
}
