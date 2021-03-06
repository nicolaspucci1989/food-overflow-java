package nutritionalCondition;

import enums.Routine;
import user.User;

public class Hypertensive extends NutritionalCondition {
    static Hypertensive INSTANCE;

    private Hypertensive() {
    }

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
