package Filters.FlightFilter;

import Filters.FilterChains.FilterChain;
import Flights.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilter {

    private FilterChain filterChain;

    public FlightFilter(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public FilterChain getChain() {
        return filterChain;
    }

    public void setChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public List<Flight> filter(List<Flight> flights)  {
        return flights.stream()
                      .filter(filterChain::applyAll)
                      .collect(Collectors.toList());
    }
}
