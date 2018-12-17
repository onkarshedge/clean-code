package com.thoughtworks.movierental;

public class HtmlStatement {
    private final String customerName;
    private final Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.customerName = name;
        this.rentals = rentals;
    }

    String html() {
        return header() + body() + footer();
    }

    private String header() {
        return "<h1>Rental Record for " + this.customerName + "</h1>";
    }

    private String footer() {
        String result = "<p>Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b></p>";
        result += "<p>You earned <b>" + String.valueOf(rentals.totalFrequentRenterPoints())
                + "</b> frequent renter points</p>";
        return result;
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            double amount = rental.amount();
            //show figures for this rental
            result += rental.getMovie().getTitle() + " " +
                    String.valueOf(amount) + "<br/>";
        }
        return result;
    }
}
