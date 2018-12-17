package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldGenerateTextStatement(){
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
        final String statement = customer.statement();
        assertEquals("Rental Record for John\n" +
                "\tAvengers\t3.5\n" +
                "\tAqua man\t9.0\n" +
                "\tLion King\t1.5\n" +
                "Amount owed is 14.0\n" +
                "You earned 4 frequent renter points", statement);
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