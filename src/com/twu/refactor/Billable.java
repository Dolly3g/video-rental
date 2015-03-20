package com.twu.refactor;

import java.util.Map;

/**
 * Created by dollyg on 3/20/2015.
 */
public interface Billable {
    double getTotalAmount();

    Map<Movie, Double> getRentalSummary();

    int getFrequentRenterPoints();

    String getName();
}
