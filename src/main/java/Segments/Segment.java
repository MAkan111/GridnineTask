package Segments;

import java.time.LocalDateTime;

public class Segment {

    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    public Segment(LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
