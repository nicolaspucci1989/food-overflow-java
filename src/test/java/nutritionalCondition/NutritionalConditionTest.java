package nutritionalCondition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

@DisplayName("Given a nutritional condition")
public class NutritionalConditionTest {
    User user;
    NutritionalCondition celiac;

    @Test
    @DisplayName("will always be corrected")
    public void celiacCondition() {
        Assertions.assertTrue(celiac.isCorrected(user));
    }

    @BeforeEach
    public void init() {
        user = new User();
        celiac = Celiac.getInstance();
    }
}
