package com.gridnine.testing.service;

import java.util.List;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.service.filter.FlightFilter;

public class LoggingFilterServiceDecorator implements FilterService {
    private final FilterService delegate;
    public LoggingFilterServiceDecorator(FilterService delegate) {
        this.delegate = delegate;
    }
    @Override
    public List<Flight> applyFilters(List<Flight> flights, List<FlightFilter> filters) {
        System.out.println("=== Применение фильтрации ===");
        System.out.println("Вход: " + flights.size() + " рейсов");
        long start = System.nanoTime();
        List<Flight> result = delegate.applyFilters(flights, filters);
        long duration = (System.nanoTime() - start) / 1_000_000; // ms
        System.out.println("Осталось: " + result.size() + " рейсов");
        System.out.println("Время выполнения: " + duration + " ms");
        return result;
    }
}