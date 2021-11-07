package ar.foodOverflow.food;

import ar.foodOverflow.enums.FoodGroup;
import ar.foodOverflow.nutritionalCondition.NutritionalCondition;

import java.util.HashSet;
import java.util.Set;

public class Food {
    public String name;
    public String description;
    public FoodGroup foodGroup;
    public Set<NutritionalCondition> inadequateConditions = new HashSet<>();

    public Food(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Food(String name, String description, FoodGroup foodGroup, Set<NutritionalCondition> inadequateConditions) {
        this.name = name;
        this.description = description;
        this.foodGroup = foodGroup;
        this.inadequateConditions = inadequateConditions;
    }

    public Food() {}

    public Food(FoodGroup _foodGroup) {
        foodGroup = _foodGroup;
    }

    public boolean valid() {
        return fieldIsValid(name) && fieldIsValid(description);
    }

    public boolean isFoodGroup(FoodGroup _foodGroup) {
        return foodGroup == _foodGroup;
    }

    /*
    *   Getters and setters
    * */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private boolean fieldIsValid(String field) {
        return field != null && field.length() > 0;
    }


}
