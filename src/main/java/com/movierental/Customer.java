package com.movierental;

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
    return new TextStatement().display(this.getName(), this.rentals, this.totalAmount(), this.totalFrequentRenterPoints());
  }

  private int totalFrequentRenterPoints() {
    return rentals.stream().mapToInt(rental -> rental.frequentRenterPoints()).sum();
  }

  private double totalAmount() {
    return rentals.stream().mapToDouble(rental -> rental.amount()).sum();
  }

  public String htmlStatement() {
    String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";
    for (Rental rental : rentals) {
      //show figures for this rental
      result += rental.getMovie().getTitle() +" "+ String.valueOf(rental.amount()) + "<br/>";
    }

    //add footer lines result
    result += "Amount owed is <b>" + String.valueOf(totalAmount()) + "</b><br/>";
    result += "You earned <b>" + String.valueOf(totalFrequentRenterPoints())
            + "</b> frequent renter points";
    return result;
  }

  private class TextStatement {
    public String display(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
      String result = "Rental Record for " + name + "\n";
      for (Rental rental : rentals) {
        //show figures for this rental
        result += "\t" + rental.getMovie().getTitle() + "\t" +
            String.valueOf(rental.amount()) + "\n";
      }

      //add footer lines result
      result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
      result += "You earned " + String.valueOf(totalFrequentRenterPoints)
          + " frequent renter points";
      return result;
    }
  }
}

