package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> testFlights = FlightBuilder.createFlights();
        List<FlightFilter> filters = new ArrayList<>(List.of(
                new FlightsBeforeCurrentTime(),
                new FlightsArrivalBeforeDeparture(),
                new FlightsLandingMoreTwoHours()
        ));
        filters.forEach(e -> {
            System.out.println(e.getFilterName());
            e.filterFlights(testFlights).forEach(System.out::println);
        });
    }
}