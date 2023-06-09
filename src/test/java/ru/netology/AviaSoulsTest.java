package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", "Сочи", 6_800, 13, 17);//4
    Ticket ticket2 = new Ticket("Москва", "Санкт-Петребург", 2_500, 23, 3);
    Ticket ticket3 = new Ticket("Сочи", "Москва", 17_000, 5, 10);
    Ticket ticket4 = new Ticket("Калининград", "Прага", 36_700, 9, 3);
    Ticket ticket5 = new Ticket("Екатеринбург", "Ставрополь", 17_000, 5, 11);
    Ticket ticket6 = new Ticket("Москва", "Сочи", 2_300, 1, 10);//9
    Ticket ticket7 = new Ticket("Москва", "Сочи", 5_600, 17, 20);//3
    Ticket ticket8 = new Ticket("Екатеринбург", "Ставрополь", 11_300, 23, 6);
    Ticket ticket9 = new Ticket("Москва", "Сочи", 6_799, 15, 21);//7
    Ticket ticket10 = new Ticket("Москва", "Сочи", 4_100, 2, 7);//5


    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        aviaSouls.add(ticket10);
    }

    @Test
    public void shouldSortWithPositiveResult() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortWithNegativeResult() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortWithEqualPrice() {

        int expected = 0;
        int actual = ticket3.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByPriceIncrease() {

        Ticket[] expected = {ticket6, ticket10, ticket7, ticket9, ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithOneMatch() {

        Ticket[] expected = {ticket4};
        Ticket[] actual = aviaSouls.search("Калининград", "Прага");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWithoutMatch() {

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Сочи", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByFlightTime() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7, ticket1, ticket10, ticket9, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByFlightTimeWithOneMatch() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Калининград", "Прага", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByFlightTimeWithoutMatch() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Калининград", "Сочи", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}