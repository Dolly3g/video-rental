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

    public Map<String, Object> calculateRentalSubTotal() {
        Map<String,Object> summary = new HashMap<String, Object>();
        Map<String, Double> rentalSubTotal = new LinkedHashMap<String,Double>();
        double totalAmount = 0;
        System.out.println(rentalList);
        for(Rental rental : rentalList){
            double amount = rental.getAmountFor();
            rentalSubTotal.put(rental.getMovie().getTitle(), amount);
            totalAmount += amount;
        }
        int frequentRenterPoints = calculateFrequentRenterPoints(rentalList);
        summary.put("rentalSubTotal",rentalSubTotal);
        summary.put("amount",totalAmount);
        summary.put("frequentRenterPoints",frequentRenterPoints);
        return summary;
    }

    private int calculateFrequentRenterPoints(List<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for(Rental rental : rentalList) {
            frequentRenterPoints = rental.isNewRelease() ? frequentRenterPoints + 2 : frequentRenterPoints + 1;
        }
        return frequentRenterPoints;
    }

    public String getStatement() {
        return new Statement(this).toString();
	}

    public String htmlStatement() {
        return new Statement(this).toHTML();
    }

    public String getName() {
        return name;
    }
}