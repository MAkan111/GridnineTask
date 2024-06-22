package Filters.FilterRules;

import Flights.Flight;

public interface FilterRule {
    boolean apply (Flight flight);
}
