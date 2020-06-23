package smilyk.actuator.endpoints.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

/** что бы заработало нужно раскомментировать @Conponent
 * пока код выложен просто для примера - как можено написать кастомную проверку
 */
//@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        Random random = new Random();

        if(random.nextBoolean()){
            return Health.down().withDetail("ERR-001", "Random failure").build();
        }

        return Health.up().build();
    }
}
