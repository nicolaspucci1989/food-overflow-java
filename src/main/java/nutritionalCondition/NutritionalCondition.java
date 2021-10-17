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


class Vegetarian extends NutritionalCondition {
    static Vegetarian INSTANCE;

    private Vegetarian() {}

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
