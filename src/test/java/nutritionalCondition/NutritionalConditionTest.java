package nutritionalCondition;

import enums.Routine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.User;

@DisplayName("Given a nutritional condition")
public class NutritionalConditionTest {
    User user;
    NutritionalCondition celiac;
    NutritionalCondition diabetic;

    @Test
    @DisplayName("will always be corrected")
    public void celiacCondition() {
        Assertions.assertTrue(celiac.isCorrected(user));
    }

    @Test
    @DisplayName("diabetic is not corrected by an user with a light routine and weight over 70")
    public void diabeticWithLightRoutine() {
        user.routine = Routine.ACTIVE;
        Assertions.assertTrue(diabetic.isCorrected(user));

    }


    @BeforeEach
    public void init() {
        user = new User();
        celiac = Celiac.getInstance();
        diabetic = Diabetic.getInstance();
    }
}
