package com.gridnine.testing.dao;

import java.util.List;
import com.gridnine.testing.entity.Flight;

public interface FlightDao {
    List<Flight> getAllFlights();
}