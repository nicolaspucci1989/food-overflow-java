package builders;

import enums.FoodGroup;
import food.Food;
import nutritionalCondition.NutritionalCondition;

import java.util.HashSet;
import java.util.Set;

public class FoodBuilder {
    private String name;
    private String description;
    private FoodGroup foodGroup;
    private Set<NutritionalCondition> inadequateConditions = new HashSet<>();

    public FoodBuilder addInadequateCondition(NutritionalCondition nutritionalCondition) {
        inadequateConditions.add(nutritionalCondition);
        return this;
    }

    public FoodBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FoodBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public FoodBuilder setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
        return this;
    }

    public Food build() {
        return new Food(name, description, foodGroup, inadequateConditions);
    }
}
