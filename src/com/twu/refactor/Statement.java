package com.twu.refactor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dollyg on 3/17/2015.
 */
public class Statement {
    Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        Map<String, Object> summary = customer.calculateRentalSubTotal();
        Map<String,Double> rentalSubTotal = (Map<String,Double>)summary.get("rentalSubTotal");
        String textStatement = "Rental Record for #{customerName}\n#{rentalSummary}" +
                "Amount owed is #{amount}\nYou earned #{frequentRenterPoints} frequent renter" +
                " points";
        String rentalSummaryTemplate = "\t#{movie}\t#{amount}\n";
        String rentalSummary = "";
        textStatement = textStatement.replace("#{customerName}",customer.getName());
        for (String movie : rentalSubTotal.keySet()){
            rentalSummary += rentalSummaryTemplate.replace("#{movie}",movie).replace("#{amount}",rentalSubTotal.get(movie)+"");
        }
        textStatement = textStatement.replace("#{rentalSummary}",rentalSummary);
        textStatement = textStatement.replace("#{amount}",summary.get("amount")+"").replace("#{frequentRenterPoints}",summary.get("frequentRenterPoints")+"");
        return textStatement;
    }

    public String toHTML() {
        Map<String, Object> summary = customer.calculateRentalSubTotal();
        Map<String,Double> rentalSubTotal = (Map<String,Double>)summary.get("rentalSubTotal");
        String statement = "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>";
        for (String movie : rentalSubTotal.keySet()){
            statement += movie + ": " + rentalSubTotal.get(movie) + "<BR>";
        }
        statement += "<P>" + "You owe <EM>" + summary.get("amount") + "</EM>" +
            "<P>On this rental you earned <EM>" + summary.get("frequentRenterPoints") +
            "</EM> frequent renter points<P>";
        return statement;
    }
}
