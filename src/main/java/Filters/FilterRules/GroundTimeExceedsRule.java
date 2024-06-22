package Filters.FilterRules;

import Flights.Flight;
import Segments.Segment;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

public class GroundTimeExceedsRule implements FilterRule, Predicate<List<Segment>> {
    private Duration maxGroundTime;

    public GroundTimeExceedsRule(Duration maxGroundTime) {
        this.maxGroundTime = maxGroundTime;
    }

    @Override
    public boolean apply(Flight flight) {
        List<Segment> segments = flight.getSegments();

        for (int i = 0; i < segments.size() - 1; i++) {
            Segment current = segments.get(i);
            Segment next = segments.get(i + 1);
            Duration groundTime = Duration.between(current.getArrivalDate(), next.getDepartureDate());

            if (groundTime.compareTo(maxGroundTime) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean test(List<Segment> segments) {
        long totalGroundTime = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment currentSegment = segments.get(i);
            Segment nextSegment = segments.get(i + 1);
            long groundTimeBetweenSegments = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate()).toHours();
            totalGroundTime += groundTimeBetweenSegments;
        }

        return totalGroundTime > maxGroundTime.toHours();
    }
}