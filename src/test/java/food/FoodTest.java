package food;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Given a food object")
public class FoodTest {
    @Test
    @DisplayName("Is valid if it has name and description")
    public void validFood() {
        Food food = new Food("name", "description");
        Assertions.assertTrue(food.valid());
    }

    @Test
    @DisplayName("Is not valid if it doesn't have name and description")
    public void notValidFood() {
        Food food = new Food("", "");
        Assertions.assertFalse(food.valid());
    }
}
