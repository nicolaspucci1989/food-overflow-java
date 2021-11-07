package ar.foodOverflow.nutritionalCondition;

import ar.foodOverflow.enums.FoodGroup;
import ar.foodOverflow.user.User;

public class Vegetarian extends NutritionalCondition {
    static Vegetarian INSTANCE;

    private Vegetarian() {
    }

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
