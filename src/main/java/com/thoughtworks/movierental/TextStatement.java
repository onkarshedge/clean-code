package com.thoughtworks.movierental;

public class TextStatement {
    private final String customerName;
    private final Rentals rentals;
    private final double totalAmount;
    private final int totalFrequentRenterPoints;

    public TextStatement(String customerName, Rentals rentals, double totalAmount, int totalFrequentRenterPoints) {
        this.customerName = customerName;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
        this.totalFrequentRenterPoints = totalFrequentRenterPoints;
    }

    String html() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + this.customerName + "\n";
    }

    private String footer() {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(this.totalFrequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            double amount = rental.amount();
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(amount) + "\n";
        }
        return result;
    }
}