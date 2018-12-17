package com.thoughtworks.movierental;

import org.junit.Test;
import org.junit.Assert;

public class CustomerTest {
    @Test
    public void testGenerateStatement() {
        final Customer customer = new Customer("Onkar");
        final Movie avengers = new Movie("Avengers", Movie.CHILDRENS);
        final Movie lionKing = new Movie("lion King", Movie.NEW_RELEASE);
        final Movie robot = new Movie("Robot", Movie.REGULAR);
        final Rental avengesRental = new Rental(avengers, 4);
        final Rental lionKingrental = new Rental(lionKing, 2);
        final Rental robotRental = new Rental(robot, 2);
        customer.addRental(avengesRental);
        customer.addRental(lionKingrental);
        customer.addRental(robotRental);
        Assert.assertEquals("Rental Record for Onkar\n" +
                "\tAvengers\t3.0\n" +
                "\tlion King\t6.0\n" +
                "\tRobot\t2.0\n" +
                "Amount owed is 11.0\n" +
                "You earned 4 frequent renter points", customer.statement());

    }

}