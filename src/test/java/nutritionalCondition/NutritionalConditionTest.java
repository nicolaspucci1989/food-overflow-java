package nutritionalCondition;

import enums.FoodGroup;
import enums.Routine;
import food.Food;
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
    NutritionalCondition hypertensive;
    NutritionalCondition vegan;

    @Test
    @DisplayName("will always be corrected")
    public void celiacCondition() {
        Assertions.assertTrue(celiac.isCorrected(user));
    }

    @Test
    @DisplayName("diabetic is not corrected by a user with a light routine and weight over 70")
    public void diabeticWithLightRoutine() {
        user.setRoutine(Routine.LIGHT);
        Assertions.assertTrue(diabetic.isCorrected(user));

    }

    @Test
    @DisplayName("diabetic is corrected by a user with an active routine")
    public void diabeticWithActiveRoutine() {
        user.setRoutine(Routine.ACTIVE);
        Assertions.assertTrue(diabetic.isCorrected(user));
    }

    @Test
    @DisplayName("diabetic is corrected by aa user with no routine and a with over 70")
    public void diabeticNoRoutine() {
        user.setWeight(50f);
        Assertions.assertTrue(diabetic.isCorrected(user));
    }

    @Test
    @DisplayName("hypertensive is corrected by aa user with an intensive routine")
    public void hypertensiveWithIntenseRoutine() {
        user.setRoutine(Routine.INTENSE);
        Assertions.assertTrue(hypertensive.isCorrected(user));
    }

    @Test
    @DisplayName("vegan is corrected by a user who has more than two fruits in its favorites foods")
    public void veganWithFruits() {
        user.addFavoriteFood(new Food(FoodGroup.VEGETABLES_FRUITS_SEEDS));
        user.addFavoriteFood(new Food(FoodGroup.VEGETABLES_FRUITS_SEEDS));
        Assertions.assertTrue(vegan.isCorrected(user));
    }


    @BeforeEach
    public void init() {
        user = new User();
        celiac = Celiac.getInstance();
        diabetic = Diabetic.getInstance();
        hypertensive = Hypertensive.getInstance();
        vegan = Vegan.getInstance();
    }
}
