package com.gridnine.testing.service.filter;

import com.gridnine.testing.entity.Flight;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate()));
    }
}