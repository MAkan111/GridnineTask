import Builders.FlightBuilder;
import Filters.FilterChains.FilterChain;
import Filters.FilterRules.ArrivalBeforeDepartureRule;
import Filters.FilterRules.DepartureAfterNowRule;
import Filters.FilterRules.GroundTimeExceedsRule;
import Filters.FlightFilter.FlightFilter;
import Flights.Flight;


import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        // Правило 1: вылет до текущего момента времени
        FilterChain departureAfterNowChain = new FilterChain();
        departureAfterNowChain.addRule(new DepartureAfterNowRule());

        List<Flight> filteredByDepartureAfterNow = new FlightFilter(departureAfterNowChain).filter(flights);
        System.out.println("Вылет до текущего момента времени:");
        filteredByDepartureAfterNow.forEach(System.out::println);

        // Правило 2: имеются сегменты с датой прилёта раньше даты вылета
        FilterChain noArrivalBeforeDepartureChain = new FilterChain();
        noArrivalBeforeDepartureChain.addRule(new ArrivalBeforeDepartureRule());

        List<Flight> filteredByNoArrivalBeforeDeparture = new FlightFilter(noArrivalBeforeDepartureChain).filter(flights);
        System.out.println("\nИмеются сегменты с датой прилёта раньше даты вылета:");
        filteredByNoArrivalBeforeDeparture.forEach(System.out::println);

        // Правило 3: общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
        FilterChain groundTimeChain = new FilterChain();
        groundTimeChain.addRule(new GroundTimeExceedsRule(Duration.ofHours(2)));

        List<Flight> filteredByGroundTime = new FlightFilter(groundTimeChain).filter(flights);
        System.out.println("\nОбщее время, проведённое на земле превышает два часа :");
        filteredByGroundTime.forEach(System.out::println);
    }
}