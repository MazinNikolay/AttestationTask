package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

class FlightsLandingMoreTwoHours implements FlightFilter {
    @Override
    public String getFilterName() {
        return "Отфильтрованы сегменты, где общее время, проведённое на земле, превышает два часа";
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream().filter(
                flight -> {
                    LocalDateTime arrivalTime;
                    LocalDateTime departureTime;
                    List<Segment> segments = flight.getSegments();
                    long duration = 0L;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        arrivalTime = segments.get(i).getArrivalDate();
                        departureTime = segments.get(i + 1).getDepartureDate();
                        duration += Duration.between(arrivalTime, departureTime).toMinutes();
                    }
                    return duration <= 120;
                }).collect(Collectors.toList());
    }
}