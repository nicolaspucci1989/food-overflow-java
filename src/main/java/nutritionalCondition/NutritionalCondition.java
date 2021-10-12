package nutritionalCondition;

import enums.FoodGroup;
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

class Hypertensive extends NutritionalCondition {
    static Hypertensive INSTANCE;

    private Hypertensive() {}

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

class Vegan extends NutritionalCondition {
    static Vegan INSTANCE;

    private Vegan() {}

    public static Vegan getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Vegan();
        }
        return INSTANCE;
    }

    @Override
    public boolean isCorrected(User user) {
        return user.amountOfFavoriteFoods(FoodGroup.VEGETABLES_FRUITS_SEEDS, 2);
    }
}
