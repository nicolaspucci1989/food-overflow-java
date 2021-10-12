package nutritionalCondition;

import enums.Routine;
import user.User;

public abstract class NutritionalCondition {
    public abstract boolean isCorrected(final User user);

    public boolean valid(final User user) {
        return true;
    }

}

class Celiac extends NutritionalCondition {
    static Celiac INSTANCE;

    private Celiac() {}

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

class Diabetic extends NutritionalCondition {
    static Diabetic INSTANCE;

    private Diabetic() {}

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
