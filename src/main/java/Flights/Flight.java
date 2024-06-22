package Flights;

import Segments.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
    private List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "segments=" + segments +
                '}';
    }

    public void addSegment(Segment segment) {
        segments.add(segment);
    }

    public void removeSegment(Segment segment) {
        segments.remove(segment);
    }
}
