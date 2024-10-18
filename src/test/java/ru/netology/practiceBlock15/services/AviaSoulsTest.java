package ru.netology.practiceBlock15.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();

    @Test
    public void comparePriceReturnPositiveNumberTest() {
        Ticket ticket1 = new Ticket("Москва", "СПб", 5000, 13, 15);
        Ticket ticket2 = new Ticket("Москва", "СПб", 3700, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparePriceReturnNegativeNumberTest() {
        Ticket ticket1 = new Ticket("Москва", "СПб", 2000, 13, 15);
        Ticket ticket2 = new Ticket("Москва", "СПб", 3700, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparePriceEqualResultTest() {
        Ticket ticket1 = new Ticket("Москва", "СПб", 2000, 13, 15);
        Ticket ticket2 = new Ticket("Москва", "СПб", 2000, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortPriceFromLowToHighTest() {
        Ticket ticket1 = new Ticket("Москва", "СПб", 5000, 13, 15);
        Ticket ticket2 = new Ticket("Москва", "СПб", 3700, 12, 14);
        Ticket ticket3 = new Ticket("Казань", "Москва", 3200, 10, 13);
        Ticket ticket4 = new Ticket("Москва", "СПб", 2900, 11, 13);
        Ticket ticket5 = new Ticket("Пермь", "Москва", 6800, 9, 14);
        Ticket ticket6 = new Ticket("Владивосток", "Москва", 6800, 9, 14);
        Ticket ticket7 = new Ticket("Москва", "СПб", 6800, 9, 10);
        Ticket ticket8 = new Ticket("Краснодар", "Хабаровск", 6800, 9, 14);
        Ticket ticket9 = new Ticket("Москва", "СПб", 5900, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket4, ticket2, ticket1, ticket9, ticket7};
        Ticket[] actual = manager.search("Москва", "СПб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundSortTest() {
        Ticket ticket1 = new Ticket("Москва", "СПб", 5000, 13, 15);
        Ticket ticket2 = new Ticket("Москва", "СПб", 3700, 12, 14);
        Ticket ticket3 = new Ticket("Казань", "Москва", 3200, 10, 13);
        Ticket ticket4 = new Ticket("Москва", "СПб", 2900, 11, 13);
        Ticket ticket5 = new Ticket("Пермь", "Москва", 6800, 9, 14);
        Ticket ticket6 = new Ticket("Владивосток", "Москва", 6800, 9, 14);
        Ticket ticket7 = new Ticket("Москва", "СПб", 6800, 9, 10);
        Ticket ticket8 = new Ticket("Краснодар", "Хабаровск", 6800, 9, 14);
        Ticket ticket9 = new Ticket("Москва", "СПб", 5900, 9, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = { };
        Ticket[] actual = manager.search("Stockholm", "NYC");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareFirstQuickerFlyTest() {
    TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва", "СПб", 5000, 11, 14);
        Ticket ticket2 = new Ticket("Москва", "СПб", 3700, 12, 14);

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = { ticket2, ticket1};
        Ticket[] actual = manager.searchAndSortBy("Москва", "СПб", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
