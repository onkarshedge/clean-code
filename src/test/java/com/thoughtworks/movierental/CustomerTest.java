package com.thoughtworks.movierental;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Rental Record for Onkar\n" +
                "\tAvengers\t3.0\n" +
                "\tlion King\t6.0\n" +
                "\tRobot\t2.0\n" +
                "Amount owed is 11.0\n" +
                "You earned 4 frequent renter points", customer.statement());

    }

    @Test
    public void shouldGenerateHTMLStatement() {
        final Customer customer = new Customer("John");
        final Movie avengers = new Movie("Avengers", Movie.REGULAR);
        final Rental avengersRental = new Rental(avengers, 3);
        customer.addRental(avengersRental);
        final Movie aquaman = new Movie("Aqua man", Movie.NEW_RELEASE);
        final Rental aquamanRental = new Rental(aquaman, 3);
        customer.addRental(aquamanRental);
        final Movie lionKing = new Movie("Lion King", Movie.CHILDRENS);
        final Rental lionKingRental = new Rental(lionKing, 3);
        customer.addRental(lionKingRental);
        final String statement = customer.htmlStatement();
        assertEquals("<h1>Rental Record for John</h1>" +
                "Avengers 3.5<br/>" +
                "Aqua man 9.0<br/>" +
                "Lion King 1.5<br/>" +
                "<p>Amount owed is <b>14.0</b></p>" +
                "<p>You earned <b>4</b> frequent renter points</p>", statement);
    }

}