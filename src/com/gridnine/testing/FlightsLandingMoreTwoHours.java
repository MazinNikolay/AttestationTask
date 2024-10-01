package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

class FlightsLandingMoreTwoHours implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> {
                    if (flight.getSegments().size() > 1) {
                        ListIterator<Segment> segmentIterator = flight.getSegments().listIterator();
                        if (segmentIterator.hasNext()) {
                            segmentIterator.next();
                        }
                        while (segmentIterator.hasNext()) {
                            LocalDateTime arrivalTime = flight.getSegments()
                                    .get(segmentIterator.previousIndex()).getArrivalDate();
                            LocalDateTime deptTime = flight.getSegments()
                                    .get(segmentIterator.nextIndex()).getDepartureDate();
                            if (deptTime.isAfter(arrivalTime.plusMinutes(119L))) {
                                return true;
                            }
                            segmentIterator.next();
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
