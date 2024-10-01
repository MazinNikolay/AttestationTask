package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> testFlights = FlightBuilder.createFlights();
        FlightFilter flightsBeforeCurrentTime = new FlightsBeforeCurrentTime();
        FlightFilter flightsArrivalBeforeDeparture = new FlightsArrivalBeforeDeparture();
        FlightFilter flightsLandingMoreTwoHours = new FlightsLandingMoreTwoHours();
        testFlights.forEach(System.out::println);
        System.out.println("//A flight departing in the past");
        System.out.println(flightsBeforeCurrentTime.filterFlights(testFlights));
        System.out.println(" //A flight that departs before it arrives");
        System.out.println(flightsArrivalBeforeDeparture.filterFlights(testFlights));
        System.out.println("//A flight with more than two hours ground time");
        System.out.println(flightsLandingMoreTwoHours.filterFlights(testFlights));
        System.out.println();
    }
}