package nutritionalCondition;

import enums.FoodGroup;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.User;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Vegetarian extends NutritionalCondition {
  private static Vegetarian INSTANCE;

  public static Vegetarian getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Vegetarian();
    }
    return INSTANCE;
  }

  @Override
  public boolean isCorrected(User user) {
    return user.isYoungerThan(30f) || !user.amountOfFavoriteFoods(FoodGroup.FATTY_OILS_SUGAR, 1);
  }
}
