package com.gridnine.testing.service.filter;

import com.gridnine.testing.entity.Flight;

public interface FlightFilter {
    boolean test(Flight flight);
}