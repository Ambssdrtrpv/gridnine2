package com.gridnine.testing;

import java.util.List;
import com.gridnine.testing.dao.FlightDao;
import com.gridnine.testing.dao.InMemoryFlightDao;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.FilterService;
import com.gridnine.testing.service.FilterServiceImpl;
import com.gridnine.testing.service.LoggingFilterServiceDecorator;
import com.gridnine.testing.service.filter.FilterFactory;
import com.gridnine.testing.service.filter.FlightFilter;

public class Main {
    public static void main(String[] args) {
        FlightDao dao = new InMemoryFlightDao();
        List<Flight> allFlights = dao.getAllFlights();

        List<FlightFilter> filters = FilterFactory.getAllFilters();

        FilterService coreService = new FilterServiceImpl();
        FilterService loggingService = new LoggingFilterServiceDecorator(coreService);

        List<Flight> filtered = loggingService.applyFilters(allFlights, filters);

        System.out.println("\nРезультат после применения всех правил:");
        filtered.forEach(System.out::println);
    }
}