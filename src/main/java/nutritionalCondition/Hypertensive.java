package nutritionalCondition;

import enums.Routine;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Hypertensive extends NutritionalCondition {
  private static Hypertensive INSTANCE;

  public static Hypertensive getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Hypertensive();
    }
    return INSTANCE;
  }

  @Override
  public boolean isCorrected(User user) {
    return user.routineIs(Routine.INTENSE);
  }
}
