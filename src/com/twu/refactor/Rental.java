package com.twu.refactor;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmountFor() {
        return movie.getCostForMovie(daysRented);
    }

    public boolean isNewRelease() {
        return movie.isNewMovie() && daysRented > 1;
    }
}