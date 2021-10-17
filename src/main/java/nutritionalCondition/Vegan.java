package nutritionalCondition;

import enums.FoodGroup;
import user.User;

public class Vegan extends NutritionalCondition {
    static Vegan INSTANCE;

    private Vegan() {
    }

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
