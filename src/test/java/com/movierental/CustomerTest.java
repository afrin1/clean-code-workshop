package com.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer = new Customer("Alice");

    @Before
    public void setup() {
        customer.addRental(new Rental(new Movie("Okja", 2), 1));
        customer.addRental(new Rental(new Movie("Thor", 0), 5));
        customer.addRental(new Rental(new Movie("Avenger", 1), 6));
    }

    @Test
    public void testStatement() {
        String expectedResult = "Rental Record for " + customer.getName() + "\n"
                +"\t" + "Okja" + "\t" + String.valueOf(1.5) + "\n"
                +"\t" + "Thor" + "\t" + String.valueOf(6.5) + "\n"
                +"\t" + "Avenger" + "\t" + String.valueOf(18.0) + "\n"
        +"Amount owed is " + String.valueOf(26.0) + "\n"
        +"You earned " + String.valueOf(4) + " frequent renter points";

        assertEquals(expectedResult, customer.statement());
    }

}