package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class ArrivalBeforeDepartureFilter implements Filtration {
    @Override
    public List<Flight> filter(List<Flight> flightList) {

        List<Flight> results = new ArrayList<>();

        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1)
                .forEach(segment -> results.add(flight)));

        return results;
    }
}
