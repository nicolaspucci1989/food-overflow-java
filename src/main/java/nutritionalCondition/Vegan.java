package nutritionalCondition;

import enums.FoodGroup;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import user.User;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Vegan extends NutritionalCondition {
    static Vegan INSTANCE;

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
