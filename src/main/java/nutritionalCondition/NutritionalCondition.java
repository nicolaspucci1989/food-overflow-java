package nutritionalCondition;

import user.User;

public abstract class NutritionalCondition {
  public abstract boolean isCorrected(final User user);

  public boolean valid(final User user) {
    return true;
  }

}


