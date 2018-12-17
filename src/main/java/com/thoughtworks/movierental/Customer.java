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
    return header() + body() + footer();
  }

  private String footer() {
    String result = "";

    result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
    result += "You earned " + String.valueOf(totalFrequentRenterPoints())
        + " frequent renter points";
    return result;
  }

  private String body() {
    String result = "";
    for (Rental each : rentals) {
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.amountFor()) + "\n";
    }
    return result;
  }

  private String header() {
    return "Rental Record for " + getName() + "\n";
  }

  private double totalAmount() {
    double totalAmount = 0;
    for (Rental each : rentals) {
      totalAmount += each.amountFor();
    }
    return totalAmount;
  }

  private int totalFrequentRenterPoints() {
    int totalFrequentRenterPoints = 0;
    for (Rental each : rentals) {
      totalFrequentRenterPoints += each.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
  }

  public String htmlStatement() {
    return htmlHeader() + htmlBody() + htmlFooter();
  }

  private String htmlFooter() {
    String result = "";

    result += "<p>Amount owed is <b>" + String.valueOf(totalAmount()) + "<b/></p>";
    result += "<p>You earned <b>" + String.valueOf(totalFrequentRenterPoints())
            + "</b> frequent renter points</p>";
    return result;
  }

  private String htmlBody() {
    String result = "";
    for (Rental each : rentals) {
      result += each.getMovie().getTitle() + " " +
              String.valueOf(each.amountFor()) + "<br/>";
    }
    return result;
  }

  private String htmlHeader() {
    return "<h1>Rental Record for " + getName() + "</h1>";
  }
}

