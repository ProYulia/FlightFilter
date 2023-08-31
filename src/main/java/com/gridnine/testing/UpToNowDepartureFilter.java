package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UpToNowDepartureFilter implements Filtration {
    @Override
    public List<Flight> filter(List<Flight> flightList) {

        List<Flight> results = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();

        for (Flight flight : flightList) {
            for (Segment segment : flight.getSegments()) {
                if (currentDateTime.isBefore(segment.getDepartureDate())) {
                    results.add(flight);
                    break;
                }
            }
        }

        return results;
    }
}
