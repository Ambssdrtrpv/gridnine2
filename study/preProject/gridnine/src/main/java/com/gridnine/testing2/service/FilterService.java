package com.gridnine.testing.service;

import java.util.List;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.filter.FlightFilter;

public interface FilterService {
    List<Flight> applyFilters(List<Flight> flights, List<FlightFilter> filters);
}