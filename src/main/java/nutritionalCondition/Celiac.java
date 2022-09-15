package nutritionalCondition;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Celiac extends NutritionalCondition {
  private static Celiac INSTANCE;

  public static Celiac getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Celiac();
    }
    return INSTANCE;
  }

  @Override
  public boolean isCorrected(User user) {
    return true;
  }
}
