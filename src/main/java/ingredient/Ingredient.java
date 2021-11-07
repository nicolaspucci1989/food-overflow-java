package ingredient;

import food.Food;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;

public class Ingredient {
    Food food;
    String quantity;

    public Ingredient(Food food, String quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Set<NutritionalCondition> inadequateConditions() {
        return food.inadequateConditions;
    }
}
