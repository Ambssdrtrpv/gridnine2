package com.gridnine.testing.service;

import java.util.List;
import java.util.stream.Collectors;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.filter.FlightFilter;

public class FilterServiceImpl implements FilterService {
    @Override
    public List<Flight> applyFilters(List<Flight> flights, List<FlightFilter> filters) {
        List<Flight> result = flights;
        for (FlightFilter filter : filters) {
            result = result.stream().filter(filter::test).collect(Collectors.toList());
        }
        return result;
    }
}