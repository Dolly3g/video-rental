package com.twu.refactor;

import java.util.*;

public class Customer implements Billable {
	private String name;
	private List<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}
	public void addRental(Rental arg) {
		rentalList.add(arg);
	}


    @Override
    public double getTotalAmount() {
        double totalAmount = 0;
        for(Rental rental : rentalList){
            totalAmount += rental.getAmountFor();
        }
        return totalAmount;
    }

    @Override
    public Map<Movie, Double> getRentalSummary() {
        Map<Movie,Double> summary = new LinkedHashMap<Movie, Double>();
        for(Rental rental : rentalList){
            summary.put(rental.getMovie(),rental.getAmountFor());
        }
        return summary;
    }

    @Override
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for(Rental rental : rentalList) {
            frequentRenterPoints = rental.isNewRelease() ? frequentRenterPoints + 2 : frequentRenterPoints + 1;
        }
        return frequentRenterPoints;
    }

    public String getStatement() {
        Billable b = this;
        return new Statement(b).toString();
	}

    public String htmlStatement() {
        Billable b = this;
        return new Statement(b).toHTML();
    }

    @Override
    public String getName() {
        return name;
    }
}