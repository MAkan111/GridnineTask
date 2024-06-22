package Filters.FilterRules;

import Filters.FilterRules.FilterRule;
import Flights.Flight;
import Segments.Segment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class DepartureAfterNowRule implements FilterRule, Predicate<List<Segment>> {
    @Override
    public boolean apply(Flight flight) {
        return flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
    }

    @Override
    public boolean test(List<Segment> segments) {
        LocalDateTime now = LocalDateTime.now();
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(now)) {
                return false;
            }
        }
        return true;
    }
}
