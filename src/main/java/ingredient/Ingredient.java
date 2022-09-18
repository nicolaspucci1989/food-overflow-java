package ingredient;

import food.Food;
import lombok.*;
import nutritionalCondition.NutritionalCondition;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingredient {
  private Food food;
  private String quantity;

  public Set<NutritionalCondition> inadequateConditions() {
    return food.getInadequateConditions();
  }
}
