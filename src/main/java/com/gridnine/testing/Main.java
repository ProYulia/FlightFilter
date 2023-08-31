package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        Filter filter1 = new Filter(new UpToNowDepartureFilter());
        Filter filter2 = new Filter(new ArrivalBeforeDepartureFilter());
        Filter filter3 = new Filter(new TimeBetweenDeparturesGreaterThanTwoHoursFilter());

        System.out.println(filter1.filter(flightList));
        System.out.println(filter2.filter(flightList));
        System.out.println(filter3.filter(flightList));
    }
}
