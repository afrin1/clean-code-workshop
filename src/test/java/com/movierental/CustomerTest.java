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
        String expectedResult = "Rental Record for Alice\n" +
                "\tOkja\t1.5\n" +
                "\tThor\t6.5\n" +
                "\tAvenger\t18.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points"; // copied from <Click to see difference> by having empty expected String in assert

        assertEquals(expectedResult, customer.statement());
    }

}