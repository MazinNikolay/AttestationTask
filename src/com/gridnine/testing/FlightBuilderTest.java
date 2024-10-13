package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

class FlightBuilderTest {

    private static final Flight normalThreeSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(4L)),
            new Segment(LocalDateTime.now().plusHours(5L), LocalDateTime.now().plusHours(6L))
    ));

    private static final Flight normalFourSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(4L)),
            new Segment(LocalDateTime.now().plusHours(5L), LocalDateTime.now().plusHours(6L)),
            new Segment(LocalDateTime.now().plusHours(7L), LocalDateTime.now().plusHours(9L))
    ));

    private static final Flight arrivalBeforeCurrentSegments = new Flight(List.of(
            new Segment(LocalDateTime.now().minusHours(1L), LocalDateTime.now().plusHours(1L))
    ));

    private static final Flight departsBeforeArrivesFourSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(4L)),
            new Segment(LocalDateTime.now().plusHours(5L), LocalDateTime.now().plusHours(6L)),
            new Segment(LocalDateTime.now().plusHours(7L), LocalDateTime.now().plusHours(6L))
    ));

    private static final Flight departsBeforeArrivesThreeSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(4L))
    ));

    private static final Flight moreThanTwoHoursGroundThreeSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(4L), LocalDateTime.now().plusHours(5L)),
            new Segment(LocalDateTime.now().plusHours(6L), LocalDateTime.now().plusHours(8L))
    ));

    private static final Flight moreThanTwoHoursGroundFiveSegments = new Flight(List.of(
            new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1L)),
            new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(3L)),
            new Segment(LocalDateTime.now().plusHours(4L), LocalDateTime.now().plusHours(5L)),
            new Segment(LocalDateTime.now().plusHours(6L), LocalDateTime.now().plusHours(7L)),
            new Segment(LocalDateTime.now().plusHours(12L), LocalDateTime.now().plusHours(13L))
    ));

    public static List<Flight> allFlights = Arrays.
            asList(normalThreeSegments, normalFourSegments, arrivalBeforeCurrentSegments,
                    departsBeforeArrivesThreeSegments, departsBeforeArrivesFourSegments,
                    moreThanTwoHoursGroundThreeSegments, moreThanTwoHoursGroundFiveSegments);

    public static List<Flight> normalFlights = Arrays.
            asList(normalThreeSegments, normalFourSegments);

    public static List<Flight> arrivalBeforeCurrentFlights = List.of(
            arrivalBeforeCurrentSegments);

    public static List<Flight> departsBeforeArrivesFlights = List.of(
            departsBeforeArrivesThreeSegments, departsBeforeArrivesFourSegments);

    public static List<Flight> moreThanTwoHoursGroundFlights = List.of(
            moreThanTwoHoursGroundThreeSegments, moreThanTwoHoursGroundFiveSegments);
}