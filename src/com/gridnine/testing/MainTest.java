package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    private static final List<FlightFilter> filters = new ArrayList<>(List.of(
            new FlightsBeforeCurrentTime(),
            new FlightsArrivalBeforeDeparture(),
            new FlightsLandingMoreTwoHours()
    ));

    @Test
    public void getNormalFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.normalFlights;
        filters.forEach(e -> {
            List<Flight> deletedFlights = new ArrayList<>(e.filterFlights(flights));
            flights.removeAll(deletedFlights);
        });
        List<Flight> actualFlights = new ArrayList<>(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void getArrivalBeforeCurrentFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.arrivalBeforeCurrentFlights;
        List<Flight> actualFlights = new FlightsBeforeCurrentTime().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void getDepartsBeforeArrivesFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.departsBeforeArrivesFlights;
        List<Flight> actualFlights = new FlightsArrivalBeforeDeparture().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void getMoreThanTwoHoursGroundFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.moreThanTwoHoursGroundFlights;
        List<Flight> actualFlights = new FlightsLandingMoreTwoHours().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }
}