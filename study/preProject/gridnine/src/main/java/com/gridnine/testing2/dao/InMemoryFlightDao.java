package com.gridnine.testing.dao;

import java.util.List;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.FlightBuilder;

public class InMemoryFlightDao implements FlightDao {
    @Override
    public List<Flight> getAllFlights() {
        return FlightBuilder.createFlights();
    }
}