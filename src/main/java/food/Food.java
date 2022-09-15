package food;

import enums.FoodGroup;
import lombok.*;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Food {
  public String name;
  public String description;
  public FoodGroup foodGroup;
  @Singular
  public Set<NutritionalCondition> inadequateConditions;

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
