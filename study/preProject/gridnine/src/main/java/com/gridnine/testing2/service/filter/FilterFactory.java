package com.gridnine.testing.service.filter;

import java.util.Arrays;
import java.util.List;

public class FilterFactory {
    public static List<FlightFilter> getAllFilters() {
        return Arrays.asList(
                new DepartureInPastFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedsTwoHoursFilter()
        );
    }
}