package food;

import enums.FoodGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;

@Getter
@Setter
@Builder
public class Food {
    public String name;
    public String description;
    public FoodGroup foodGroup;
    @Singular
    public Set<NutritionalCondition> inadequateConditions;


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

    private boolean fieldIsValid(String field) {
        return field != null && field.length() > 0;
    }


}
