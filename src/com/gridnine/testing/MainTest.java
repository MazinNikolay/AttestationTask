package com.gridnine.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void filterArrivalBeforeCurrentFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.filterArrivalBeforeCurrentFlights;
        List<Flight> actualFlights = new FlightsBeforeCurrentTime().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void filterDepartsBeforeArrivesFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.filterDepartsBeforeArrivesFlights;
        List<Flight> actualFlights = new FlightsArrivalBeforeDeparture().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }

    @Test
    public void filterMoreThanTwoHoursGroundFlightsTest() {
        List<Flight> flights = new ArrayList<>(FlightBuilderTest.allFlights);
        List<Flight> expectedFlights = FlightBuilderTest.filterMoreThanTwoHoursGroundFlights;
        List<Flight> actualFlights = new FlightsLandingMoreTwoHours().filterFlights(flights);
        Assert.assertEquals(expectedFlights, actualFlights);
    }
}