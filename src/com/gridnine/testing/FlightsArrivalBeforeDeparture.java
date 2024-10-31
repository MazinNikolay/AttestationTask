package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

class FlightsArrivalBeforeDeparture implements FlightFilter {

    @Override
    public String getFilterName() {
        return "Отфильтрованы сегменты с датой прилёта раньше даты вылета";
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}