package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    int totalFrequentRenterPoints() {
      return stream().mapToInt(rental -> rental.frequentRenterPoints()).sum();
    }

    double totalAmount() {
      return stream().mapToDouble(rental -> rental.amount()).sum();
    }
}
