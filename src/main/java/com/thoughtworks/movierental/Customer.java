package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = Rental.totalAmount(rentals);
        int totalFrequentRenterPoints = Rental.totalFrequentRenterPoints(rentals);
        return header() + body() + footer(totalAmount, totalFrequentRenterPoints);
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String footer(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
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

