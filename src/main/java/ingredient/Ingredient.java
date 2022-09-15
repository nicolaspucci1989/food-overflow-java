package ingredient;

import food.Food;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
  private Food food;
  private String quantity;

  public Set<NutritionalCondition> inadequateConditions() {
    return food.inadequateConditions;
  }
}
