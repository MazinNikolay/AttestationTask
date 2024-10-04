package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

class FlightsBeforeCurrentTime implements FlightFilter {
    LocalDateTime currentTime = LocalDateTime.now();

    @Override
    public String getFilterName() {
        return "Сегменты с вылетом до текущего момента времени";
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment
                                .getDepartureDate().isBefore(currentTime)))
                .collect(Collectors.toList());
    }
}