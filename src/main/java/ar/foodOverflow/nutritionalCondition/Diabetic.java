package ar.foodOverflow.nutritionalCondition;

import ar.foodOverflow.enums.Routine;
import ar.foodOverflow.user.User;

public class Diabetic extends NutritionalCondition {
    static Diabetic INSTANCE;

    private Diabetic() {
    }

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
