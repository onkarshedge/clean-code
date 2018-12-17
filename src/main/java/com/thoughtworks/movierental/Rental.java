package com.thoughtworks.movierental;

import java.util.List;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

   static double totalAmount(List<Rental> rentals) {
      double totalAmount = 0;
      for (Rental rental : rentals) {
          totalAmount += rental.amount();
      }
      return totalAmount;
  }

  static int totalFrequentRenterPoints(List<Rental> rentals) {
      int frequentRenterPoints = 0;
      for (Rental rental : rentals) {
          frequentRenterPoints++;
          if (rental.isFrequentRenter()) frequentRenterPoints++;
      }
      return frequentRenterPoints;
  }

  double amount() {
    double amount = 0;
    //determine amounts for each line
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (getDaysRented() > 2)
          amount += (getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (getDaysRented() > 3)
          amount += (getDaysRented() - 3) * 1.5;
        break;
    }
    return amount;
  }

  private int getDaysRented() {
    return daysRented;
  }

  Movie getMovie() {
    return movie;
  }

  private boolean isFrequentRenter() {
      return movie.isNewRelease() && getDaysRented() > 1;
  }

}