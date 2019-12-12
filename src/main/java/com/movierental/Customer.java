package com.movierental;

public class Customer {
  private String name;
  private Rentals rentals = new Rentals();

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
    return new TextStatement().display(this.getName(), this.rentals);
  }

  public String htmlStatement() {
    String result = "<h1>Rental Record for <b>" + getName() + "</b></h1><br/>";
    for (Rental rental : rentals) {
      //show figures for this rental
      result += rental.getMovie().getTitle() +" "+ String.valueOf(rental.amount()) + "<br/>";
    }

    //add footer lines result
    result += "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br/>";
    result += "You earned <b>" + String.valueOf(rentals.totalFrequentRenterPoints())
            + "</b> frequent renter points";
    return result;
  }

}

