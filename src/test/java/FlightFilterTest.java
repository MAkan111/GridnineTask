import Builders.FlightBuilder;
import Filters.FilterChains.FilterChain;
import Filters.FilterRules.ArrivalBeforeDepartureRule;
import Filters.FilterRules.DepartureAfterNowRule;
import Filters.FilterRules.GroundTimeExceedsRule;
import Filters.FlightFilter.FlightFilter;
import Flights.Flight;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FlightFilterTest {

    @Test
    public void testFlightFilter() {
        // Подготовка данных
        List<Flight> flights = FlightBuilder.createFlights();

        // Создание фильтра и применение
        FilterChain filterChain = new FilterChain();
        filterChain.addRule(new DepartureAfterNowRule());
        filterChain.addRule(new ArrivalBeforeDepartureRule());
        filterChain.addRule(new GroundTimeExceedsRule(Duration.ofHours(2)));

        FlightFilter flightFilter = new FlightFilter(filterChain);
        List<Flight> filteredFlights = flightFilter.filter(flights);

        // Проверка результатов
        assertNotNull(filteredFlights);
        assertFalse(filteredFlights.isEmpty());

        System.out.println("Filtered flights:");
        filteredFlights.forEach(System.out::println);
    }
}