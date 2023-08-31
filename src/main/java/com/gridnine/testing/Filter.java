package com.gridnine.testing;

import java.util.List;

public class Filter {

    private Filtration filtration;

    public Filter(Filtration filtration) {
        this.filtration = filtration;
    }

    public List<Flight> filter(List<Flight> flightList) {
        return filtration.filter(flightList);
    }
}
