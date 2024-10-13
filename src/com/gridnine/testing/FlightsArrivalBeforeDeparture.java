package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

class FlightsArrivalBeforeDeparture implements FlightFilter {

    @Override
    public String getFilterName() {
        return "Сегменты с датой прилёта раньше даты вылета";
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate()
                                .isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
