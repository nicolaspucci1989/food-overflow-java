package nutritionalCondition;

import enums.Routine;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Diabetic extends NutritionalCondition {
  private static Diabetic INSTANCE;

  public static Diabetic getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Diabetic();
    }
    return INSTANCE;
  }

  @Override
  public boolean isCorrected(User user) {
    return user.routineIs(Routine.ACTIVE) || user.exceedsWeight(70f);
  }
}
