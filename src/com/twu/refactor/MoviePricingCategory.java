package com.twu.refactor;

/**
 * Created by dollyg on 3/18/2015.
 */
public enum MoviePricingCategory {
    KIDS(1.5,1.5,3),
    REGULAR(2,1.5,2),
    NEW_RELEASE(0,3,0);

    private double upFrontCost;
    private double perDayCost;
    private int upFrontValidity;

    MoviePricingCategory(double upFrontCost, double perDayCost, int upFrontValidity) {
        this.upFrontCost = upFrontCost;
        this.perDayCost = perDayCost;
        this.upFrontValidity = upFrontValidity;
    }

    public double getCostFor(int days) {
       double rentalAmount = upFrontCost;
        if (days > upFrontValidity)
            rentalAmount += (days - upFrontValidity) * perDayCost;
        return rentalAmount;
    }
}
