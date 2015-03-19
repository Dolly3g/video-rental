package com.twu.refactor;

public class Movie {

    private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

    public boolean isNewMovie(){
        return priceCode == MoviePricingCategory.NEW_RELEASE;
    }
	public void setPriceCode(MoviePricingCategory arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

   public double getCostForMovie(int daysRented) {
        return priceCode.getCostFor(daysRented);
    }
}

