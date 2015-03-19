package com.twu.refactor;

import java.util.*;

public class Customer {
	private String name;
	private List<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}
	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

    private Statement calculateRentalSubTotal() {
        Map<String, Double> rentalSubTotal = new LinkedHashMap<String,Double>();
        double totalAmount = 0;
        for(Rental rental : rentalList){
            double amount = rental.getAmountFor();
            rentalSubTotal.put(rental.getMovie().getTitle(), amount);
            totalAmount += amount;
        }
        int frequentRenterPoints = calculateFrequentRenterPoints(rentalList);
        return new Statement(name, rentalSubTotal,totalAmount,frequentRenterPoints);
    }

    private int calculateFrequentRenterPoints(List<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for(Rental rental : rentalList){
            frequentRenterPoints = rental.isNewRelease() ? frequentRenterPoints+2 : frequentRenterPoints+1;
   }
        return frequentRenterPoints;
    }

    public String getStatement() {
        return calculateRentalSubTotal().toString();
	}

    public String htmlStatement() {
        return calculateRentalSubTotal().toHTML();
    }
}