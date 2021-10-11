package food;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Given a food object")
public class FoodTest {
    Food food;

    @Test
    @DisplayName("Is valid if it has name and description")
    public void validFood() {
        food.setName("name");
        food.setDescription("description");
        Assertions.assertTrue(food.valid());
    }

    @Test
    @DisplayName("Is not valid if it doesn't have name and description")
    public void notValidFood() {
        Assertions.assertFalse(food.valid());
    }

    @Test
    @DisplayName("Is not valid if it has a name and it doesn't have a description")
    public void foodWithoutDescription() {
        food.setName("name");
        Assertions.assertFalse(food.valid());
    }

    @Test
    @DisplayName("Is not valid if it has a description but it doesn't have a name")
    public void footWithoutName() {
        food.setDescription("description");
        Assertions.assertFalse(food.valid());
    }


    @BeforeEach
    public void init() {
        food = new Food();
    }

}
