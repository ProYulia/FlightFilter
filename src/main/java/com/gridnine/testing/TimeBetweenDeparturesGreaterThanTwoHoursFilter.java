package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimeBetweenDeparturesGreaterThanTwoHoursFilter implements Filtration {
    @Override
    public List<Flight> filter(List<Flight> flightList) {

        List<Flight> results = new ArrayList<>();

        flightList.forEach(flight -> {
            int segmentCount = flight.getSegments().size();
            if (segmentCount > 1) {
                int totalHours = 0;

                for (int i = 1; i < segmentCount; i++) {
                    LocalDateTime arrivalDate = flight.getSegments().get(i - 1).getArrivalDate();
                    LocalDateTime departureDate = flight.getSegments().get(i).getDepartureDate();
                    totalHours += (int) ChronoUnit.HOURS.between(arrivalDate, departureDate);
                }
                if (totalHours <= 2) results.add(flight);

            } else results.add(flight);
        });

        return results;
    }
}
