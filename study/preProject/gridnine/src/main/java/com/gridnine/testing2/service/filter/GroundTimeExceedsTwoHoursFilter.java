package com.gridnine.testing.service.filter;

import java.time.temporal.ChronoUnit;
import com.gridnine.testing.entity.Flight;
import com.gridnine.testing.entity.Segment;
import java.util.List;

public class GroundTimeExceedsTwoHoursFilter implements FlightFilter {
    @Override
    public boolean test(Flight flight) {
        long groundMinutes = 0;
        List<Segment> segs = flight.getSegments();
        for (int i = 0; i < segs.size() - 1; i++) {
            var arrival = segs.get(i).getArrivalDate();
            var nextDeparture = segs.get(i + 1).getDepartureDate();
            if (nextDeparture.isAfter(arrival)) {
                groundMinutes += ChronoUnit.MINUTES.between(arrival, nextDeparture);
            }
        }
        return groundMinutes <= 120;
    }
}