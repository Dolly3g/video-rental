package com.twu.refactor;

import java.util.Map;

/**
 * Created by dollyg on 3/17/2015.
 */
public class Statement {
    private Billable billable;

    public Statement(Billable billable) {
        this.billable = billable;
    }

    private String getBody(String BODY) {
        Map<Movie,Double> rentalSummary = billable.getRentalSummary();
        String textRentalSummary = "";
        for (Movie movie : rentalSummary.keySet()){
            String template = new String(BODY);
            textRentalSummary += template.replace("#{movie}",movie.getTitle())
                    .replace("#{amount}",rentalSummary.get(movie)+"");
        }
        return textRentalSummary;
    }

    private String getHeader(String HEADER) {
        return HEADER.replace("#{customer}",billable.getName());
    }

    private String getFooter(String FOOTER) {
        return FOOTER.replace("#{amount}", billable.getTotalAmount()+"")
                .replace("#{frp}", billable.getFrequentRenterPoints() + "");
    }

    @Override
    public String toString() {
        String HEADER = "Rental Record for #{customer}";
        String FOOTER = "Amount owed is #{amount}\nYou earned #{frp} frequent renter points";
        String RENTAL_SUMMARY = "\t#{movie}\t#{amount}\n";
        return getHeader(HEADER) + "\n" + getBody(RENTAL_SUMMARY) + getFooter(FOOTER) ;
    }

    public String toHTML() {
        String HEADER = "<H1>Rentals for <EM>#{customer}</EM></H1><P>";
        String RENTAL_SUMMARY = "#{movie}: #{amount}<BR>";
        String FOOTER = "<P>You owe <EM>#{amount}</EM><P>On this rental you earned <EM>" +
                "#{frp}</EM> frequent renter points<P>";

        return getHeader(HEADER) + getBody(RENTAL_SUMMARY) + getFooter(FOOTER);
    }
}

