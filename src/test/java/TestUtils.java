
import Flights.Flight;
import Segments.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static Flight createFlightWithSegments(LocalDateTime... dates) {
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < dates.length - 1; i += 2) {
            LocalDateTime departure = dates[i];
            LocalDateTime arrival = dates[i + 1];
            segments.add(new Segment(departure, arrival));
        }
        return new Flight(segments);
    }

    public static void addSegment(Flight flight, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        flight.addSegment(new Segment(departureDate, arrivalDate));
    }
}