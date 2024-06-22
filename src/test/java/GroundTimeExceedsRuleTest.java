import Filters.FilterRules.GroundTimeExceedsRule;
import Flights.Flight;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GroundTimeExceedsRuleTest {

    @Test
    public void testGroundTimeExceeds() {
        // Подготовка данных
        LocalDateTime now = LocalDateTime.now();
        Flight flight1 = TestUtils.createFlightWithSegments(now, now.plusHours(1), now.plusHours(2), now.plusHours(3));
        Flight flight2 = TestUtils.createFlightWithSegments(now, now.plusHours(1), now.plusHours(2), now.plusHours(2).plusMinutes(30));

        // Создание правила и применение
        GroundTimeExceedsRule rule = new GroundTimeExceedsRule(Duration.ofHours(2));
        boolean result1 = rule.test(flight1.getSegments());

        // Проверка результатов
        assertFalse(result1);
    }
}