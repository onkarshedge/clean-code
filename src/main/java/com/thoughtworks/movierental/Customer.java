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
        double totalAmount = totalAmount();
        int frequentRenterPoints = frequentRenterPoints();
        return getHeader() + getBody() +  getFooter(totalAmount, frequentRenterPoints);
    }

    private String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private String getBody() {
        String result = "";
        for (Rental each : rentals) {
            double amount = each.amountFor();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(amount) + "\n";
        }
        return result;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            double amount = each.amountFor();
            totalAmount += amount;
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    &&
                    each.getDaysRented() > 1) frequentRenterPoints++;

        }
        return frequentRenterPoints;
    }

}

