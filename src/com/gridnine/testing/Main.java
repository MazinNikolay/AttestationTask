package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> testFlights = new ArrayList<>(FlightBuilder.createFlights());

        List<FlightFilter> filters = new ArrayList<>(List.of(
                new FlightsBeforeCurrentTime(),
                new FlightsArrivalBeforeDeparture(),
                new FlightsLandingMoreTwoHours()
        ));
        System.out.println("Все перелеты:");
        testFlights.forEach(System.out::println);
        filters.forEach(e -> {
            System.out.println(e.getFilterName());
            List<Flight> deletedFlights = new ArrayList<>(e.filterFlights(testFlights));
            System.out.println(deletedFlights);
            testFlights.removeAll(deletedFlights);
        });
        System.out.println("Все перелеты после фильтрации:");
        testFlights.forEach(System.out::println);
    }
}