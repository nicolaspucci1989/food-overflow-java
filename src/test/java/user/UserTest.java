package user;

import enums.Routine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Given a user")
public class UserTest {
    User user;

    @Test
    @DisplayName("it's bmi is equal to the user's weight divided by it's squared height")
    public void bmi() {
        assertEquals(27.7508f, user.bmi(), 0.001f);
    }

    @BeforeEach
    public void init() {
        user = new User(Routine.ACTIVE, 80.2f, 1.7f, new HashSet<>(), LocalDate.now().minusYears(22));
    }
}
