package ingredient;

import food.Food;
import lombok.AllArgsConstructor;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;

@AllArgsConstructor
public class Ingredient {
    Food food;
    String quantity;

    public Set<NutritionalCondition> inadequateConditions() {
        return food.inadequateConditions;
    }
}
