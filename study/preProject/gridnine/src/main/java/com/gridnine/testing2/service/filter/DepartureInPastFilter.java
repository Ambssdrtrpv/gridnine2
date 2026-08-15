package com.gridnine.testing.service.filter;

import java.time.LocalDateTime;
import com.gridnine.testing.entity.Flight;

public class DepartureInPastFilter implements FlightFilter {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream()
                .noneMatch(s -> s.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}