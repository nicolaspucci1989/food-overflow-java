package recipe;

import ingredient.Ingredient;
import user.User;

import java.util.List;
import java.util.Set;

public class SimpleRecipe extends Recipe{
    Set<Ingredient> ingredients;
    Float calories;
    List<String> preparationSteps;

    public SimpleRecipe(User author,
                        Set<User> collaborators,
                        float calories,
                        List<String> preparationSteps,
                        Set<Ingredient> ingredients) {
        super(author, collaborators);
        this.ingredients = ingredients;
        this.calories = calories;
        this.preparationSteps = preparationSteps;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public float getCalories() {
        return calories;
    }

    @Override
    public List<String> getPreparationSteps() {
        return preparationSteps;
    }
}
