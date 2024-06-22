import Filters.FilterRules.ArrivalBeforeDepartureRule;
import Flights.Flight;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class ArrivalBeforeDepartureRuleTest {

    @Test
    public void testArrivalBeforeDeparture() {
        // Подготовка данных
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = TestUtils.createFlightWithSegments(now.plusHours(1), now.plusHours(2));
        Flight flight2 = TestUtils.createFlightWithSegments(now.plusHours(1), now.plusHours(1).minusMinutes(30));

        // Создание правила и применение
        ArrivalBeforeDepartureRule rule = new ArrivalBeforeDepartureRule();
        boolean result1 = rule.test(flight1.getSegments());
        boolean result2 = rule.test(flight2.getSegments());

        // Проверка результатов
        assertFalse(result1);
        assertTrue(result2);
    }
}