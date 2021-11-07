package ar.foodOverflow.nutritionalCondition;

import ar.foodOverflow.user.User;

public class Celiac extends NutritionalCondition {
    static Celiac INSTANCE;

    private Celiac() {
    }

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
