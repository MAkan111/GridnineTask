package Filters.FilterRules;

import Flights.Flight;
import Segments.Segment;

import java.util.List;
import java.util.function.Predicate;

public class ArrivalBeforeDepartureRule implements FilterRule, Predicate<List<Segment>> {
    @Override
    public boolean apply(Flight flight) {
        return flight.getSegments().stream().
                allMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate()));
    }

    @Override
    public boolean test(List<Segment> segments) {
        for (Segment segment : segments) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return true;
            }
        }
        return false;
    }
}
