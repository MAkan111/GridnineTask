import Filters.FilterRules.DepartureAfterNowRule;
import Flights.Flight;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class DepartureAfterNowRuleTest {

    @Test
    public void testDepartureAfterNow() {
        // Подготовка данных
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = TestUtils.createFlightWithSegments(now.plusHours(1), now.plusHours(2));
        Flight flight2 = TestUtils.createFlightWithSegments(now.minusHours(1), now.plusHours(1));

        // Создание правила и применение
        DepartureAfterNowRule rule = new DepartureAfterNowRule();
        boolean result1 = rule.test(flight1.getSegments());
        boolean result2 = rule.test(flight2.getSegments());

        // Проверка результатов
        assertTrue(result1);
        assertFalse(result2);
    }
}